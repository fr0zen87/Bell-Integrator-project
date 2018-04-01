package ru.bellintegrator.practice.account.views;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterView {

    @NotNull(message = "login is required")
    @Email
    @NotBlank
    private String login;

    @NotNull(message = "password is required")
    @Size(min = 6, message = "password length must be more than 5")
    @NotBlank
    private String password;

    @NotNull(message = "name is required")
    @Size(max = 255, message = "name length must be less than 256")
    private String name;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
