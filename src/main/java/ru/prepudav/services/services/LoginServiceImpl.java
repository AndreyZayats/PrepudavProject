package ru.prepudav.services.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.prepudav.services.models.User;
import ru.prepudav.services.repositories.TokensRepository;
import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.models.Token;
import ru.prepudav.services.repositories.UsersRepository;
import ru.prepudav.services.transfer.TokenDto;

import java.util.Optional;

import static ru.prepudav.services.transfer.TokenDto.from;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());
        if(userCandidate.isPresent()) {
            User user = userCandidate.get();
            if(passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
