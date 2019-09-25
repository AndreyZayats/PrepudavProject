package ru.prepudav.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.services.LoginUserService;
import ru.prepudav.services.transfer.TokenUserDto;

@RestController
public class LoginUserController {
    @Autowired
    private LoginUserService loginUserService;

    @PostMapping("/login")
    public ResponseEntity<TokenUserDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginUserService.login(loginForm));
    }
}
