package ru.prepudav.services.services;

import ru.prepudav.services.forms.LoginAdminForm;
import ru.prepudav.services.transfer.TokenAdminDto;
import ru.prepudav.services.transfer.TokenUserDto;

public interface LoginAdminService {
    TokenAdminDto loginAdmin(LoginAdminForm loginAdminForm);
}
