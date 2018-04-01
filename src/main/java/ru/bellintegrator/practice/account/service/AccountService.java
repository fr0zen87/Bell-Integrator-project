package ru.bellintegrator.practice.account.service;

import ru.bellintegrator.practice.account.views.LoginView;
import ru.bellintegrator.practice.account.views.RegisterView;

public interface AccountService {

    void register(RegisterView view) throws Exception;

    void checkCode(String code);

    void login(LoginView view) throws Exception;
}
