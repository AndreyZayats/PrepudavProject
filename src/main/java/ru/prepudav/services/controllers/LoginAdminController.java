package ru.prepudav.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.prepudav.services.forms.LoginAdminForm;
import ru.prepudav.services.services.LoginAdminService;
import ru.prepudav.services.transfer.TokenAdminDto;

@RestController
public class LoginAdminController {
    @Autowired
    private LoginAdminService loginAdminService;

    @PostMapping("/loginAdmin")
    public ResponseEntity<TokenAdminDto> login(@RequestBody LoginAdminForm loginAdminForm) {
        return ResponseEntity.ok(loginAdminService.loginAdmin(loginAdminForm));
    }
}
