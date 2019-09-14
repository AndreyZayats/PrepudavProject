package ru.prepudav.services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prepudav.services.models.User;
import ru.prepudav.services.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<User> findOne(Long userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }
}
