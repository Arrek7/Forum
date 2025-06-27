package com.comarch.szkolenia.forum.dao;

import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.model.Topic;

import java.util.List;

public interface IPostDAO {
    List<Post> getAll();
    Post getById(int id);
    void persist(Post post);




}
