package views.components;

import j2html.tags.ContainerTag;
import services.question.types.QuestionType;

/** Class to hold constants for icons and provide methods for rendering SVG components. */
public class Icons {
  public static final String ADDRESS_SVG_PATH =
      "M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38"
          + " 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z";
  public static final String ANNOTATION_SVG_PATH =
      "M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z";
  // Checkbox
  public static final String CHECKBOX_SVG_PATH = "M5 21Q4.175 21 3.587 20.413Q3 19.825 3 19V5Q3 "
      + "4.175 3.587 3.587Q4.175 3 5 3H19Q19.825 3 20.413 3.587Q21 4.175 21 5V19Q21 19.825 20.413 "
      + "20.413Q19.825 21 19 21ZM5 19H19Q19 19 19 19Q19 19 19 19V5Q19 5 19 5Q19 5 19 5H5Q5 5 5 5Q5 "
      + "5 5 5V19Q5 19 5 19Q5 19 5 19ZM10.6 16.2 17.65 9.15 16.25 7.75 10.6 13.4 7.75 10.55 6.35 "
      + "11.95ZM5 19Q5 19 5 19Q5 19 5 19V5Q5 5 5 5Q5 5 5 5Q5 5 5 5Q5 5 5 5V19Q5 19 5 19Q5 19 5 19Z";
  public static final String CURRENCY_SVG_PATH =
      "M12 8c-1.657 0-3 .895-3 2s1.343 2 3 2 3 .895 3"
          + " 2-1.343 2-3 2m0-8c1.11 0 2.08.402 2.599 1M12 8V7m0 1v8m0 0v1m0-1c-1.11"
          + " 0-2.08-.402-2.599-1M21 12a9 9 0 11-18 0 9 9 0 0118 0z";
  public static final String DATE_SVG_PATH =
      "M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z";
  // Format List Bulleted
  public static final String DROPDOWN_SVG_PATH = "M4.5 13.5Q3.875 13.5 3.438 13.062Q3 12.625 3 "
      + "12Q3 11.375 3.438 10.938Q3.875 10.5 4.5 10.5Q5.125 10.5 5.562 10.938Q6 11.375 6 12Q6 "
      + "12.625 5.562 13.062Q5.125 13.5 4.5 13.5ZM4.5 7.5Q3.875 7.5 3.438 7.062Q3 6.625 3 6Q3 "
      + "5.375 3.438 4.938Q3.875 4.5 4.5 4.5Q5.125 4.5 5.562 4.938Q6 5.375 6 6Q6 6.625 5.562 "
      + "7.062Q5.125 7.5 4.5 7.5ZM4.5 19.5Q3.875 19.5 3.438 19.062Q3 18.625 3 18Q3 17.375 3.438 "
      + "16.938Q3.875 16.5 4.5 16.5Q5.125 16.5 5.562 16.938Q6 17.375 6 18Q6 18.625 5.562 "
      + "19.062Q5.125 19.5 4.5 19.5ZM8 19V17H21V19ZM8 13V11H21V13ZM8 7V5H21V7Z";
  public static final String EMAIL_SVG_PATH =
      "M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2"
          + " 0 002 2z";
  // Replay
  public static final String ENUMERATOR_SVG_PATH =
      "M12 22Q10.125 22 8.488 21.288Q6.85 20.575 5.638 19.362Q4.425 18.15 3.712 16.512Q3 14.875 3 "
          + "13H5Q5 15.925 7.038 17.962Q9.075 20 12 20Q14.925 20 16.962 17.962Q19 15.925 19 13Q19 "
          + "10.075 16.962 8.037Q14.925 6 12 6H11.85L13.4 7.55L12 9L8 5L12 1L13.4 2.45L11.85 "
          + "4H12Q13.875 4 15.513 4.713Q17.15 5.425 18.363 6.637Q19.575 7.85 20.288 9.487Q21 "
          + "11.125 21 13Q21 14.875 20.288 16.512Q19.575 18.15 18.363 19.362Q17.15 20.575 15.513 "
          + "21.288Q13.875 22 12 22Z";
  // Upload
  public static final String FILEUPLOAD_SVG_PATH =
      "M3 17a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM6.293 6.707a1 1 0 010-1.414l3-3a1 1 0"
          + " 011.414 0l3 3a1 1 0 01-1.414 1.414L11 5.414V13a1 1 0 11-2 0V5.414L7.707 6.707a1 1 0"
          + " 01-1.414 0z";
  // Badge
  public static final String ID_SVG_PATH =
      "M14 13.5H18V12H14ZM14 16.5H18V15H14ZM15 7H20Q20.825 7 21.413 7.587Q22 8.175 22 9V20Q22 20.825"
          + " 21.413 21.413Q20.825 22 20 22H4Q3.175 22 2.588 21.413Q2 20.825 2 20V9Q2 8.175 2.588 "
          + "7.587Q3.175 7 4 7H9V4Q9 3.175 9.588 2.587Q10.175 2 11 2H13Q13.825 2 14.413 2.587Q15 "
          + "3.175 15 4ZM11 9H13V4H11ZM12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 "
          + "14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 "
          + "12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5Q12 14.5 12 14.5ZM9 15Q9.625 15 10.062 "
          + "14.562Q10.5 14.125 10.5 13.5Q10.5 12.875 10.062 12.438Q9.625 12 9 12Q8.375 12 7.938 "
          + "12.438Q7.5 12.875 7.5 13.5Q7.5 14.125 7.938 14.562Q8.375 15 9 15ZM6 18H12V17.55Q12 "
          + "17.125 11.762 16.762Q11.525 16.4 11.1 16.2Q10.6 15.975 10.088 15.863Q9.575 15.75 9 "
          + "15.75Q8.425 15.75 7.913 15.863Q7.4 15.975 6.9 16.2Q6.475 16.4 6.238 16.762Q6 17.125 6 "
          + "17.55ZM9 9H4Q4 9 4 9Q4 9 4 9V20Q4 20 4 20Q4 20 4 20H20Q20 20 20 20Q20 20 20 20V9Q20 9 "
          + "20 9Q20 9 20 9H15Q15 9.825 14.413 10.412Q13.825 11 13 11H11Q10.175 11 9.588 10.412Q9 "
          + "9.825 9 9Z";
  public static final String NAME_SVG_PATH =
      "M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 3c1.66 0 3 1.34"
          + " 3 3s-1.34 3-3 3-3-1.34-3-3 1.34-3 3-3zm0 14.2c-2.5 0-4.71-1.28-6-3.22.03-1.99"
          + " 4-3.08 6-3.08 1.99 0 5.97 1.09 6 3.08-1.29 1.94-3.5 3.22-6 3.22z";
  // Number sign
  public static final String NUMBER_SVG_PATH =
      "M6 20 7 16H3L3.5 14H7.5L8.5 10H4.5L5 8H9L10 4H12L11 8H15L16 4H18L17 8H21L20.5 10H16.5L15.5 "
          + "14H19.5L19 16H15L14 20H12L13 16H9L8 20ZM9.5 14H13.5L14.5 10H10.5Z";
  public static final String PLUS_SVG_PATH =
      "M10 5a1 1 0 011 1v3h3a1 1 0 110 2h-3v3a1 1 0 11-2 0v-3H6a1 1 0 110-2h3V6a1 1 0 011-1z";
  public static final String SEARCH_SVG_PATH =
      "M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23"
          + "  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92"
          + "  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z"
          + " M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17 s-17-7.626-17-17S14.61,6,23.984,6z";
  // Radio Button Checked
  public static final String RADIO_BUTTON = "M12 17Q14.075 17 15.538 15.537Q17 "
      + "14.075 17 12Q17 9.925 15.538 8.462Q14.075 7 12 7Q9.925 7 8.463 8.462Q7 9.925 7 12Q7 "
      + "14.075 8.463 15.537Q9.925 17 12 17ZM12 22Q9.925 22 8.1 21.212Q6.275 20.425 4.925 19."
      + "075Q3.575 17.725 2.788 15.9Q2 14.075 2 12Q2 9.925 2.788 8.1Q3.575 6.275 4.925 4.925Q6.275 "
      + "3.575 8.1 2.787Q9.925 2 12 2Q14.075 2 15.9 2.787Q17.725 3.575 19.075 4.925Q20.425 6.275 "
      + "21.212 8.1Q22 9.925 22 12Q22 14.075 21.212 15.9Q20.425 17.725 19.075 19.075Q17.725 20.425 "
      + "15.9 21.212Q14.075 22 12 22ZM12 12Q12 12 12 12Q12 12 12 12Q12 12 12 12Q12 12 12 12Q12 12 "
      + "12 12Q12 12 12 12Q12 12 12 12Q12 12 12 12ZM12 20Q15.325 20 17.663 17.663Q20 15.325 20 "
      + "12Q20 8.675 17.663 6.337Q15.325 4 12 4Q8.675 4 6.338 6.337Q4 8.675 4 12Q4 15.325 6.338 "
      + "17.663Q8.675 20 12 20Z";
  // Text Field
  public static final String TEXT_SVG_PATH = "M20.125 15 18 12.875 18.725 12.15Q19 11.875 19.425 "
      + "11.875Q19.85 11.875 20.125 12.15L20.85 12.875Q21.125 13.15 21.125 13.575Q21.125 14 20.85 "
      + "14.275ZM12 21V18.875L17.3 13.575L19.425 15.7L14.125 21ZM3 16V14H10V16ZM3 12V10H14V12ZM3 "
      + "8V6H14V8Z";
  public static final String UNKNOWN_SVG_PATH =
      "M11 18h2v-2h-2v2zm1-16C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0"
          + " 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm0-14c-2.21 0-4 1.79-4"
          + " 4h2c0-1.1.9-2 2-2s2 .9 2 2c0 2-3 1.75-3 5h2c0-2.25 3-2.5 3-5"
          + " 0-2.21-1.79-4-4-4z";
  public static final String TRASH_CAN_SVG_PATH =
      "M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1"
          + " 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16";
  public static final String WARNING_SVG_PATH =
      "M8.257 3.099c.765-1.36 2.722-1.36 3.486 0l5.58 9.92c.75 1.334-.213 2.98-1.742"
          + " 2.98H4.42c-1.53 0-2.493-1.646-1.743-2.98l5.58-9.92zM11 13a1 1 0 11-2 0 1 1 0 012"
          + " 0zm-1-8a1 1 0 00-1 1v3a1 1 0 002 0V6a1 1 0 00-1-1z";

  public static final String ACCORDION_BUTTON_PATH = "M19 9l-7 7-7-7";

  public static ContainerTag questionTypeSvg(QuestionType type, int size) {
    return questionTypeSvg(type, size, size);
  }

  public static ContainerTag questionTypeSvg(QuestionType type, int width, int height) {
    String iconPath = "";
    switch (type) {
      case ADDRESS:
        iconPath = Icons.ADDRESS_SVG_PATH;
        break;
      case CHECKBOX:
        return svg(Icons.CHECKBOX_SVG_PATH, width, height);
      case CURRENCY:
        return svg(Icons.CURRENCY_SVG_PATH, width, height)
            .attr("fill", "none")
            .attr("stroke-linecap", "round")
            .attr("stroke-linejoin", "round")
            .attr("stroke-width", "2");
      case DATE:
        return svg(Icons.DATE_SVG_PATH, width, height)
            .attr("fill", "none")
            .attr("stroke-linecap", "round")
            .attr("stroke-linejoin", "round")
            .attr("stroke-width", "2");
      case DROPDOWN:
        return svg(Icons.DROPDOWN_SVG_PATH, width, height);
      case EMAIL:
        return svg(Icons.EMAIL_SVG_PATH, width, height)
            .attr("fill", "none")
            .attr("stroke-linecap", "round")
            .attr("stroke-linejoin", "round")
            .attr("stroke-width", "2");
      case FILEUPLOAD:
        return svg(Icons.FILEUPLOAD_SVG_PATH, width, height)
            .attr("fill-rule", "evenodd")
            .attr("clip-rule", "evenodd");
      case ID:
        return svg(Icons.ID_SVG_PATH, width, height);
      case NAME:
        iconPath = Icons.NAME_SVG_PATH;
        break;
      case NUMBER:
        return svg(Icons.NUMBER_SVG_PATH, width, height);
      case RADIO_BUTTON:
        return svg(Icons.RADIO_BUTTON, width, height);
      case ENUMERATOR:
        iconPath = Icons.ENUMERATOR_SVG_PATH;
        return svg(iconPath, width, height);
      case STATIC:
        return svg(Icons.ANNOTATION_SVG_PATH, width, height)
            .attr("fill", "none")
            .attr("stroke-linecap", "round")
            .attr("stroke-linejoin", "round")
            .attr("stroke-width", "2");
      case TEXT:
        iconPath = Icons.TEXT_SVG_PATH;
        return svg(iconPath, width, height);
      default:
        iconPath = Icons.UNKNOWN_SVG_PATH;
    }
    return svg(iconPath, width, height);
  }

  public static ContainerTag svg(String pathString, int pixelSize) {
    return svg(pathString, pixelSize, pixelSize);
  }

  public static ContainerTag svg(String pathString, int width, int height) {
    return svg(pathString).attr("viewBox", String.format("0 0 %1$d %2$d", width, height));
  }

  private static ContainerTag svg(String pathString) {
    return svg().with(path(pathString));
  }

  private static ContainerTag svg() {
    return new ContainerTag("svg")
        .attr("xmlns", "http://www.w3.org/2000/svg")
        .attr("fill", "currentColor")
        .attr("stroke", "currentColor")
        .attr("stroke-width", "1%")
        .attr("aria-hidden", "true");
  }

  private static ContainerTag path(String pathString) {
    return new ContainerTag("path").attr("d", pathString);
  }
}
