package ru.prepudav.services.services;

import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
