package ru.prepudav.services.services;

import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.transfer.TokenAdminDto;

public interface LoginAdminService {
    TokenAdminDto loginAdmin(LoginForm loginAdminForm);
}
