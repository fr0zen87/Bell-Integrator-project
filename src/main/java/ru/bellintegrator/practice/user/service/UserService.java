package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;
import ru.bellintegrator.practice.user.views.responces.UserListView;
import ru.bellintegrator.practice.user.views.responces.UserView;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface UserService {

    /**
     * @param filters - filters to find users
     * @return users founded by filters
     */
    List<UserListView> list(Map<String, Object> filters);

    /**
     * @param id - primary key of user
     * @return an user
     */
    UserView loadById(Long id);

    /**
     * @param update - user to update
     */
    void update(UserUpdateRequest update);

    /**
     * @param id - primary key of user to delete
     */
    void delete(Long id);

    /**
     * @param save - user to save
     */
    void save(UserSaveRequest save);
}
