package ru.prepudav.services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prepudav.services.forms.UserForm;
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
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .age(userForm.getAge())
                .university(userForm.getUniversity())
                .role(Role.USER)
                .state(State.ACTIVE).build();

        usersRepository.save(user);
    }
}
