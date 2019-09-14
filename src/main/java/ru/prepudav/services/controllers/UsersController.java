package ru.prepudav.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.prepudav.services.models.User;
import ru.prepudav.services.services.UserService;
import ru.prepudav.services.transfer.UserDto;

import java.util.List;
import java.util.Optional;

import static ru.prepudav.services.transfer.UserDto.from;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return from(userService.findAll());
    }

    @GetMapping("/users/{user-id}")
    public Optional<User> getUser(@PathVariable("user-id") Long userId) {
        return userService.findOne(userId);
    }
}
