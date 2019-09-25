package ru.prepudav.services.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.prepudav.services.models.User;
import ru.prepudav.services.repositories.TokensUsersRepository;
import ru.prepudav.services.forms.LoginForm;
import ru.prepudav.services.models.UserToken;
import ru.prepudav.services.repositories.UsersRepository;
import ru.prepudav.services.transfer.TokenUserDto;

import java.util.Optional;

import static ru.prepudav.services.transfer.TokenUserDto.from;

@Component
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    private TokensUsersRepository tokensUsersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenUserDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());
        if(userCandidate.isPresent()) {
            User user = userCandidate.get();
            if(passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                UserToken userToken = UserToken.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensUsersRepository.save(userToken);
                return from(userToken);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
