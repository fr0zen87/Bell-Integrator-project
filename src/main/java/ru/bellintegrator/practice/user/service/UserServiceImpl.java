package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.views.requests.UserSaveRequest;
import ru.bellintegrator.practice.user.views.requests.UserUpdateRequest;
import ru.bellintegrator.practice.user.views.responces.UserListView;
import ru.bellintegrator.practice.user.views.responces.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserListView> list(Map<String, Object> filters) {
        List<UserListView> usersView = new ArrayList<>();
        dao.list(filters).forEach(user -> {
            UserListView view = new UserListView(user);
            log.debug(view.toString());
            usersView.add(view);
        });
        return usersView;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView loadById(Long id) {
        UserView view = new UserView(dao.loadById(id));
        log.debug(view.toString());
        return view;
    }

    @Override
    @Transactional
    public void update(UserUpdateRequest update) {
        dao.update(update);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void save(UserSaveRequest save) {
        dao.save(save);
    }
}
