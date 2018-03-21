package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;

import java.util.List;
import java.util.Map;

/**
 * Dao to work with User
 */
public interface UserDao {

    /**
     * @param filters - filters to find users
     * @return users founded by filters
     */
    List<User> list(Map<String, Object> filters);

    /**
     * @param id - user primary key
     * @return an user
     */
    User loadById(Long id);

    /**
     * @param update - user to update
     */
    void update(UserUpdateRequest update);

    /**
     * @param id - user primary key
     */
    void delete(Long id);

    /**
     * @param save - user to save
     */
    void save(UserSaveRequest save);
}
