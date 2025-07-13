package com.comarch.szkolenia.forum.services.impl;

import com.comarch.szkolenia.forum.dao.IUserDAO;
import com.comarch.szkolenia.forum.model.User;
import com.comarch.szkolenia.forum.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserDAO userDAO;

    @Override
    public Optional<User> getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void updateUser(User user) {
        userDAO.persist(user);
    }

    @Override
    public void changePassword(int userId, String newPassword) {
        Optional<User> userOpt = userDAO.getById(userId);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setPassword(newPassword);
            userDAO.persist(user);
        }
    }

    @Override
    public void banUser(int userId) {
        Optional<User> userOpt = userDAO.getById(userId);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setBanned(true);
            userDAO.persist(user);
        }
    }

    @Override
    public void unbanUser(int userId) {
        Optional<User> userOpt = userDAO.getById(userId);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setBanned(false);
            userDAO.persist(user);
        }
    }

    @Override
    public void changeRole(int userId, User.Role newRole) {
        Optional<User> userOpt = userDAO.getById(userId);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
            user.setRole(newRole);
            userDAO.persist(user);
        }
    }
}
