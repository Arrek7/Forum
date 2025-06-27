package com.comarch.szkolenia.forum.dao;

import com.comarch.szkolenia.forum.model.User;

import java.util.List;

public interface IUserDAO {
    void persist(User user);
    User getById(int id);
    User getByLogin(String login);
    List<User> getAll();
}
