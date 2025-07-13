package com.comarch.szkolenia.forum.dao.impl.memory;

import com.comarch.szkolenia.forum.dao.ITopicDAO;
import com.comarch.szkolenia.forum.model.Topic;
import com.comarch.szkolenia.forum.services.IIdSequence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class TopicRepository implements ITopicDAO {
    private final List<Topic> topics = new ArrayList<>();
    private final IIdSequence idSequence;

    public TopicRepository(IIdSequence idSequence) {
        this.idSequence = idSequence;
        this.topics.add(
                new Topic(1,  "NBA 2025",
                        "Admin", "2025-06-22", Collections.emptyList()));
        this.topics.add(
                new Topic(2, "EuroBasket",
                        "Admin", "2025-06-23", Collections.emptyList()));
        this.topics.add(
                new Topic(3, "StreetBall",
                        "Admin", "2025-06-24", Collections.emptyList()));
    }

    @Override
    public Optional<Topic> getById(int id) {
        for(Topic topic : this.topics){
            if(topic.getId() == id){
                return Optional.of(topic);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Topic> getAll() {
        return this.topics;
    }

    @Override
    public void persist(Topic topic) {
        topic.setId(this.idSequence.getNextId());
        this.topics.add(topic);

    }
}
