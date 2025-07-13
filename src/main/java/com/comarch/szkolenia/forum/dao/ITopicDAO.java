package com.comarch.szkolenia.forum.dao;

import com.comarch.szkolenia.forum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicDAO {
    Optional<Topic> getById(int id);
    List<Topic> getAll();
    void persist(Topic topic);
}
