package ru.prepudav.services.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int age;
    private String university;
}
