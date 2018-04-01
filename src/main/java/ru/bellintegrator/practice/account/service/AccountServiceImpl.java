package ru.bellintegrator.practice.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.account.dao.AccountDao;
import ru.bellintegrator.practice.account.views.LoginView;
import ru.bellintegrator.practice.account.views.RegisterView;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao dao;

    @Autowired
    public AccountServiceImpl(AccountDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void register(RegisterView view) throws Exception {
        dao.register(view);
    }

    @Override
    @Transactional
    public void checkCode(String code) {
        dao.checkCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public void login(LoginView view) throws Exception {
        dao.login(view);
    }
}
