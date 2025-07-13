package com.comarch.szkolenia.forum.services.impl;

import com.comarch.szkolenia.forum.dao.ITopicDAO;
import com.comarch.szkolenia.forum.model.Topic;
import com.comarch.szkolenia.forum.services.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {
    private final ITopicDAO topicDAO;

    public List<Topic> getAllTopics() {
        return topicDAO.getAll();
    }

    public Optional<Topic> getTopicById(int id) {
        return topicDAO.getById(id);
    }

    public void addTopic(Topic topic) {
        topicDAO.persist(topic);
    }
}
