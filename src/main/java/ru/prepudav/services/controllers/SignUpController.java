package ru.prepudav.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.prepudav.services.forms.SignUpForm;
import ru.prepudav.services.services.SignUpService;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService service;

    @PostMapping("/signUp")
    public String signUp(@RequestBody SignUpForm signUpForm) {
        service.signUp(signUpForm);
        return ResponseEntity.ok("new user with login " + signUpForm.getLogin() + " is created").toString();
    }
}
