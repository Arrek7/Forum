package com.comarch.szkolenia.forum.dao;

import com.comarch.szkolenia.forum.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    void persist(User user);
    Optional<User> getById(int id);
    Optional<User> getByLogin(String login);
    List<User> getAll();
}
