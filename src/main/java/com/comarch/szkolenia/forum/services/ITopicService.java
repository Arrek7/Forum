package com.comarch.szkolenia.forum.services;

import com.comarch.szkolenia.forum.model.Topic;
import java.util.List;
import java.util.Optional;

public interface ITopicService {
    List<Topic> getAllTopics();
    Optional<Topic> getTopicById(int id);
    void addTopic(Topic topic);
}

