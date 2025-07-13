package com.comarch.szkolenia.forum.services;

import com.comarch.szkolenia.forum.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> getById(int id);
    Optional<User> getByLogin(String login);
    List<User> getAll();
    void updateUser(User user);
    void changePassword(int userId, String newPassword);
    void banUser(int userId);
    void unbanUser(int userId);
    void changeRole(int userId, User.Role newRole);
}

