package views.admin.questions;

import static com.google.common.base.Preconditions.checkNotNull;
import static j2html.TagCreator.div;

import com.google.common.collect.ImmutableList;
import j2html.tags.DomContent;
import j2html.tags.specialized.FormTag;
import java.util.Locale;
import java.util.Optional;
import javax.inject.Inject;
import play.i18n.Langs;
import play.mvc.Http;
import play.twirl.api.Content;
import services.LocalizedStrings;
import services.question.QuestionOption;
import services.question.types.EnumeratorQuestionDefinition;
import services.question.types.MultiOptionQuestionDefinition;
import services.question.types.QuestionDefinition;
import views.HtmlBundle;
import views.admin.AdminLayout;
import views.admin.AdminLayout.NavPage;
import views.admin.AdminLayoutFactory;
import views.admin.TranslationFormView;
import views.components.FieldWithLabel;
import views.components.ToastMessage;

/** Renders a list of languages to select from, and a form for updating question information. */
public final class QuestionTranslationView extends TranslationFormView {

  private final AdminLayout layout;

  @Inject
  public QuestionTranslationView(AdminLayoutFactory layoutFactory, Langs langs) {
    super(checkNotNull(langs));
    this.layout = checkNotNull(layoutFactory).getLayout(NavPage.QUESTIONS);
  }

  public Content render(Http.Request request, Locale locale, QuestionDefinition question) {
    return render(request, locale, question, Optional.empty());
  }

  public Content renderErrors(
      Http.Request request, Locale locale, QuestionDefinition invalidQuestion, String errors) {
    return render(request, locale, invalidQuestion, Optional.of(errors));
  }

  private Content render(
      Http.Request request, Locale locale, QuestionDefinition question, Optional<String> errors) {
    String formAction =
        controllers.admin.routes.AdminQuestionTranslationsController.update(
                question.getId(), locale.toLanguageTag())
            .url();

    // Add form fields for questions.
    ImmutableList.Builder<DomContent> inputFieldsBuilder =
        ImmutableList.<DomContent>builder()
            .add(
                questionTextFields(
                    locale, question.getQuestionText(), question.getQuestionHelpText()));
    Optional<DomContent> questionTypeSpecificContent =
        getQuestionTypeSpecificContent(question, locale);
    if (questionTypeSpecificContent.isPresent()) {
      inputFieldsBuilder.add(questionTypeSpecificContent.get());
    }

    FormTag form = renderTranslationForm(request, locale, formAction, inputFieldsBuilder.build());

    String title = String.format("Manage Question Translations: %s", question.getName());

    HtmlBundle htmlBundle =
        layout
            .getBundle()
            .setTitle(title)
            .addMainContent(
                renderHeader(title), renderLanguageLinks(question.getId(), locale), form);
    errors.ifPresent(s -> htmlBundle.addToastMessages(ToastMessage.error(s).setDismissible(false)));

    return layout.renderCentered(htmlBundle);
  }

  @Override
  protected String languageLinkDestination(long questionId, Locale locale) {
    return controllers.admin.routes.AdminQuestionTranslationsController.edit(
            questionId, locale.toLanguageTag())
        .url();
  }

  private Optional<DomContent> getQuestionTypeSpecificContent(
      QuestionDefinition question, Locale toUpdate) {
    switch (question.getQuestionType()) {
      case CHECKBOX: // fallthrough intended
      case DROPDOWN: // fallthrough intended
      case RADIO_BUTTON:
        MultiOptionQuestionDefinition multiOption = (MultiOptionQuestionDefinition) question;
        return multiOptionQuestionFields(multiOption.getOptions(), toUpdate);
      case ENUMERATOR:
        EnumeratorQuestionDefinition enumerator = (EnumeratorQuestionDefinition) question;
        return enumeratorQuestionFields(enumerator.getEntityType(), toUpdate);
      case ADDRESS: // fallthrough intended
      case CURRENCY: // fallthrough intended
      case FILEUPLOAD: // fallthrough intended
      case NAME: // fallthrough intended
      case NUMBER: // fallthrough intended
      case TEXT: // fallthrough intended
      default:
        return Optional.empty();
    }
  }

  private DomContent questionTextFields(
      Locale locale, LocalizedStrings questionText, LocalizedStrings helpText) {
    ImmutableList.Builder<DomContent> fields = ImmutableList.builder();
    fields.add(
        div()
            .with(
                FieldWithLabel.input()
                    .setFieldName("questionText")
                    .setLabelText("Question text")
                    .setValue(questionText.maybeGet(locale))
                    .getInputTag())
            .condWith(!isDefaultLocale(locale), defaultLocaleTextHint(questionText)));

    // Help text is optional - only show if present.
    if (!helpText.isEmpty()) {
      fields.add(
          div()
              .with(
                  FieldWithLabel.input()
                      .setFieldName("questionHelpText")
                      .setLabelText("Question help text")
                      .setValue(helpText.maybeGet(locale))
                      .getInputTag())
              .condWith(!isDefaultLocale(locale), defaultLocaleTextHint(helpText)));
    }

    return fieldSetForFields("Question details (visible to applicants)", fields.build());
  }

  private Optional<DomContent> multiOptionQuestionFields(
      ImmutableList<QuestionOption> options, Locale toUpdate) {
    if (options.isEmpty()) {
      return Optional.empty();
    }
    ImmutableList.Builder<DomContent> optionFieldsBuilder = ImmutableList.builder();
    for (int optionIdx = 0; optionIdx < options.size(); optionIdx++) {
      QuestionOption option = options.get(optionIdx);
      optionFieldsBuilder.add(
          div()
              .with(
                  FieldWithLabel.input()
                      .setFieldName("options[]")
                      .setLabelText(String.format("Answer option #%d", optionIdx + 1))
                      .setValue(option.optionText().maybeGet(toUpdate).orElse(""))
                      .getInputTag())
              .condWith(!isDefaultLocale(toUpdate), defaultLocaleTextHint(option.optionText())));
    }

    return Optional.of(fieldSetForFields("Answer options", optionFieldsBuilder.build()));
  }

  private Optional<DomContent> enumeratorQuestionFields(
      LocalizedStrings entityType, Locale toUpdate) {
    return Optional.of(
        div()
            .with(
                FieldWithLabel.input()
                    .setFieldName("entityType")
                    .setLabelText("What is being enumerated")
                    .setValue(entityType.maybeGet(toUpdate).orElse(""))
                    .getInputTag())
            .condWith(!isDefaultLocale(toUpdate), defaultLocaleTextHint(entityType)));
  }
}
