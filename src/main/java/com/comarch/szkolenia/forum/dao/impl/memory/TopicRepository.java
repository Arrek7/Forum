package com.comarch.szkolenia.forum.dao.impl.memory;

import com.comarch.szkolenia.forum.dao.ITopicDAO;
import com.comarch.szkolenia.forum.model.Topic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicRepository implements ITopicDAO {
    private final List<Topic> topics = new ArrayList<>();
    private int lastId = 3;

    public TopicRepository() {
        this.topics.add(
                new Topic(1, "NBA 2025",
                        "Admin", "2025-06-22"));
        this.topics.add(
                new Topic(2, "EuroBasket",
                        "Admin", "2025-06-23"));
        this.topics.add(
                new Topic(3, "StreetBall",
                        "Admin", "2025-06-24"));
    }

    @Override
    public Topic getById(int id) {
        for(Topic topic : this.topics){
            if(topic.getId() == id){
                return topic;
            }
        }
        return null;
    }

    @Override
    public List<Topic> getAll() {
        return this.topics;
    }

    @Override
    public void persist(Topic topic) {
        topic.setId(++this.lastId);
        this.topics.add(topic);

    }
}
