package ru.bellintegrator.practice.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.account.service.AccountService;
import ru.bellintegrator.practice.account.views.LoginView;
import ru.bellintegrator.practice.account.views.RegisterView;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountControllerImpl implements AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterView view) throws Exception {

        accountService.register(view);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/activation",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> activation(@RequestParam(name = "code") String code) {

        accountService.checkCode(code);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody @Valid LoginView view) throws Exception {

        accountService.login(view);
        return ResponseEntity.ok().body(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }
}
