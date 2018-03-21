package ru.bellintegrator.practice.user.controller;

import org.springframework.http.ResponseEntity;
import ru.bellintegrator.practice.user.views.requests.UserDeleteRequest;
import ru.bellintegrator.practice.user.views.requests.UserFilter;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

/**
 * User controller
 */
public interface UserController {

    /**
     * Find users by filter
     */
    ResponseEntity<Object> list(UserFilter filter);

    /**
     * Find user by id
     */
    ResponseEntity<Object> loadById(Long id) throws Exception;

    /**
     * Update user
     */
    ResponseEntity<Object> update(UserUpdateRequest update);

    /**
     * Delete user
     */
    ResponseEntity<Object> delete(UserDeleteRequest delete);

    /**
     * Save user
     */
    ResponseEntity<Object> save(UserSaveRequest save);
}
