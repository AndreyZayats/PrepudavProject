package ru.prepudav.services.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.prepudav.services.forms.LoginAdminForm;
import ru.prepudav.services.models.Admin;
import ru.prepudav.services.models.AdminToken;
import ru.prepudav.services.repositories.AdminRepository;
import ru.prepudav.services.repositories.TokensAdminRepository;
import ru.prepudav.services.transfer.TokenAdminDto;

import java.util.Optional;

import static ru.prepudav.services.transfer.TokenAdminDto.from;


@Component
public class LoginAdminServiceImpl implements LoginAdminService {
    @Autowired
    private TokensAdminRepository tokensAdminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public TokenAdminDto loginAdmin(LoginAdminForm loginAdminForm) {
        Optional<Admin> adminCandidate = adminRepository.findOneByLogin(loginAdminForm.getLogin());
        if(adminCandidate.isPresent()) {
            Admin admin = adminCandidate.get();
            if(passwordEncoder.matches(loginAdminForm.getPassword(), admin.getHashPassword())) {
                AdminToken token = AdminToken.builder()
                        .admin(admin)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensAdminRepository.save(token);
                return from(token);
            }
        } throw new IllegalArgumentException("Admin not found");
    }
}
