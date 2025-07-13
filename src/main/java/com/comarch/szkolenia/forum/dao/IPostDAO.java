package com.comarch.szkolenia.forum.dao;

import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface IPostDAO {
    List<Post> getAll();
    Optional<Post> getById(int id);
    void persist(Post post);
    List<Post> getAllByTopicId(int topicId);
    void deletePost(int id);




}
