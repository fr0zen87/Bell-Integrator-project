package ru.bellintegrator.practice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.views.requests.UserDeleteRequest;
import ru.bellintegrator.practice.user.views.requests.UserFilter;
import ru.bellintegrator.practice.user.views.requests.UserFilterHelper;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @RequestMapping(value = "/list",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> list(@RequestBody @Valid UserFilter filter) {

        Map<String, Object> filters = UserFilterHelper.getFilters(filter);
        return ResponseEntity.ok(Collections.singletonMap("data", userService.list(filters)));
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> loadById(@PathVariable("id") Long id) throws Exception {

        if (id < 1) throw new Exception("id must be greater than 0");
        return ResponseEntity.ok(Collections.singletonMap("data", userService.loadById(id)));
    }

    @Override
    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @Valid UserUpdateRequest update) {

        userService.update(update);
        return ResponseEntity.ok(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@RequestBody @Valid UserDeleteRequest delete) {

        userService.delete(delete.getId());
        return ResponseEntity.ok(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }

    @Override
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @Valid UserSaveRequest save) {

        userService.save(save);
        return ResponseEntity.ok(Collections.singletonMap("data", Collections.singletonMap("result", "success")));
    }
}
