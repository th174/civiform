import subprocess
import os
import shutil
import shlex
from typing import Optional

from cloud.shared.bin.lib.config_loader import ConfigLoader


# TODO(#2741): When using this for Azure make sure to setup backend bucket prior to calling these functions.
def perform_apply(
        config_loader: ConfigLoader,
        is_destroy=False,
        terraform_template_dir: Optional[str] = None):
    '''Generates terraform variable files and runs terraform init and apply.'''
    if not terraform_template_dir:
        terraform_template_dir = config_loader.get_template_dir()
    tf_vars_filename = config_loader.tfvars_filename

    terraform_cmd = f'terraform -chdir={terraform_template_dir}'

    if config_loader.is_dev():
        print(" - Run terraform init -upgrade -reconfigure")
        subprocess.check_call(
            shlex.split(f'{terraform_cmd} init -upgrade -reconfigure'))
    else:
        print(" - Run terraform init -upgrade -reconfigure")
        init_cmd = f'{terraform_cmd} init -input=false -upgrade'
        # backend vars file can be absent when pre-terraform setup is running
        if os.path.exists(os.path.join(terraform_template_dir,
                                       config_loader.backend_vars_filename)):
            init_cmd += f' -backend-config={config_loader.backend_vars_filename}'
        subprocess.check_call(shlex.split(init_cmd))

    if os.path.exists(os.path.join(terraform_template_dir, tf_vars_filename)):
        print(
            f'{tf_vars_filename} exists in {terraform_template_dir} directory')
    else:
        raise ValueError(
            f'Aborting the script. {tf_vars_filename} does not exist in {terraform_template_dir} directory'
        )

    print(" - Run terraform apply")
    terraform_apply_cmd = f'{terraform_cmd} apply -input=false -var-file={tf_vars_filename}'
    if is_destroy:
        terraform_apply_cmd += " -destroy"
    subprocess.check_call(shlex.split(terraform_apply_cmd))
    return True


def copy_backend_override(config_loader: ConfigLoader):
    ''' 
    Copies the terraform backend_override to backend_override.tf (used to
    make backend local instead of a shared state for dev deploys)
    '''
    backend_override_path = os.path.join(
        config_loader.get_template_dir(), 'backend_override')
    if not os.path.exists(backend_override_path):
        print(f'{backend_override_path} does not exist.')
        return

    shutil.copy(
        backend_override_path,
        os.path.join(config_loader.get_template_dir(), 'backend_override.tf'))
