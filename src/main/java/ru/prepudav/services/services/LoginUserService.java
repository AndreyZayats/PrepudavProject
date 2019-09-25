package ru.prepudav.services.services;

import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.transfer.TokenUserDto;

public interface LoginUserService {
    TokenUserDto login(LoginForm loginForm);
}
