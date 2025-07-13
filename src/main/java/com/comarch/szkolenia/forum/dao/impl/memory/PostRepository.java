package com.comarch.szkolenia.forum.dao.impl.memory;

import com.comarch.szkolenia.forum.dao.IPostDAO;
import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.services.IIdSequence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostRepository implements IPostDAO {
    private final List<Post> posts = new ArrayList<>();
    private final IIdSequence idSequence;

    public PostRepository (IIdSequence idSequence) {
        this.idSequence = idSequence;
        this.posts.add(new Post(1, 1, "Admin", "LeBron znów w formie!", "2025-06-22"));
        this.posts.add(new Post(2, 2, "Admin", "Kto wygra EuroBasket?", "2025-06-23"));
        this.posts.add(new Post(3, 3,"Admin", "StreetBall to nie tylko gra!", "2025-06-24"));

    }
    @Override
    public Optional<Post> getById(int id) {
        for(Post post : this.posts) {
            if(post.getId() == id) {
                return Optional.of(post);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Post> getAll() {
        return this.posts;

    }

    @Override
    public void persist(Post post) {
        post.setId(this.idSequence.getNextId());
        this.posts.add(post);
    }

    @Override
    public List<Post> getAllByTopicId(int topicId) {
        List<Post> result = new ArrayList<>();
        for(Post post : this.posts) {
            if(post.getTopicId() == topicId) {
                result.add(post);
            }
        }
        return result;
    }
}
