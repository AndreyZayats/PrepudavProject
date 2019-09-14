package ru.prepudav.services.services;

import ru.prepudav.services.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findOne(Long userId);
    List<User> findAll();
}
