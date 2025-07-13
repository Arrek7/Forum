package com.comarch.szkolenia.forum.services;

import com.comarch.szkolenia.forum.model.User;

public interface IAuthenticationService {
    void register(User user);
    void authenticate(String username, String password);
    void logout();
}
