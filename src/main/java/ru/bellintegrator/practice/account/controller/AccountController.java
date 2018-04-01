package ru.bellintegrator.practice.account.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.account.views.LoginView;
import ru.bellintegrator.practice.account.views.RegisterView;

public interface AccountController {

    ResponseEntity<Object> register(RegisterView view) throws Exception;

    ResponseEntity<Object> activation(String code);

    ResponseEntity<Object> login(LoginView view) throws Exception;
}
