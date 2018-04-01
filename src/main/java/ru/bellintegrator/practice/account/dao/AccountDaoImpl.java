package ru.bellintegrator.practice.account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.account.model.Account;
import ru.bellintegrator.practice.account.views.LoginView;
import ru.bellintegrator.practice.account.views.RegisterView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Base64;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private final EntityManager em;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    public AccountDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void register(RegisterView view) throws Exception {
        String queryString = "SELECT a FROM Account a WHERE a.login = '" + view.getLogin() +"'";
        if (em.createQuery(queryString).getResultList().size() != 0) {
            throw new Exception("Account already exists");
        }
        Account account = new Account();
        account.setLogin(view.getLogin());
        account.setPassword(Base64.getEncoder().encodeToString(view.getPassword().getBytes()));
        account.setName(view.getName());
        String code = Base64.getEncoder().encodeToString(view.getLogin().getBytes());
        account.setCode(code);
        em.persist(account);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(view.getLogin());
        message.setSubject("Activation code");
        message.setText(code);
        emailSender.send(message);
    }

    @Override
    public void checkCode(String code) {
        String queryString = "SELECT a FROM Account a WHERE a.code = '" + code + "'";
        List<Account> list = em.createQuery(queryString, Account.class).getResultList();
        if (list.size() == 0) {
            throw new NullPointerException("Wrong code");
        }
        list.get(0).setCode(null);
    }

    @Override
    public void login(LoginView view) throws Exception {
        String queryString = "SELECT a FROM Account a WHERE a.login=:login AND a.password=:password";
        TypedQuery<Account> query = em.createQuery(queryString, Account.class);
        query.setParameter("login", view.getLogin());
        query.setParameter("password",
                Base64.getEncoder().encodeToString(view.getPassword().getBytes()));
        List<Account> list = query.getResultList();
        if (list.size() == 0) {
            throw new NullPointerException("Invalid login or password");
        }
        if (list.get(0).getCode() != null) {
            throw new Exception("Account not activated");
        }
    }
}
