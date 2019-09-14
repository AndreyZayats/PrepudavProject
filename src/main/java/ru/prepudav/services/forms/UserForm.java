package ru.prepudav.services.forms;

import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int age;
    private String university;
}
