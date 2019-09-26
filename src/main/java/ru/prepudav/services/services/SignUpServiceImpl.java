package ru.prepudav.services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prepudav.services.forms.SignUpForm;
import ru.prepudav.services.models.Role;
import ru.prepudav.services.models.State;
import ru.prepudav.services.models.User;
import ru.prepudav.services.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(SignUpForm signUpForm) {
        String hashPassword = passwordEncoder.encode(signUpForm.getPassword());
        if(signUpForm.isTeacher()) {User user = User.builder()
                .firstName(signUpForm.getFirstName())
                .lastName(signUpForm.getLastName())
                .hashPassword(hashPassword)
                .login(signUpForm.getLogin())
                .age(signUpForm.getAge())
                .university(signUpForm.getUniversity())
                .isTeacher(signUpForm.isTeacher())
                .role(Role.TEACHER)
                .state(State.ACTIVE).build();
            usersRepository.save(user);
        } else {
            User user = User.builder()
                    .firstName(signUpForm.getFirstName())
                    .lastName(signUpForm.getLastName())
                    .hashPassword(hashPassword)
                    .login(signUpForm.getLogin())
                    .age(signUpForm.getAge())
                    .university(signUpForm.getUniversity())
                    .isTeacher(!signUpForm.isTeacher())
                    .role(Role.USER)
                    .state(State.ACTIVE).build();
            usersRepository.save(user);
        }
    }
}
