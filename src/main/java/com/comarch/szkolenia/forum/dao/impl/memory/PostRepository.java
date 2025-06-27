package com.comarch.szkolenia.forum.dao.impl.memory;

import com.comarch.szkolenia.forum.dao.IPostDAO;
import com.comarch.szkolenia.forum.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostRepository implements IPostDAO {
    private final List<Post> posts = new ArrayList<>();
    private int lastId = 3;

    public PostRepository () {
        this.posts.add(new Post(1, "Admin", "LeBron znów w formie!", "NBA 2025", "2025-06-22"));
        this.posts.add(new Post(2, "Janusz", "Kto wygra EuroBasket?", "EuroBasket", "2025-06-23"));
        this.posts.add(new Post(3, "Admin", "StreetBall to nie tylko gra!", "StreetBall", "2025-06-24"));

    }
    @Override
    public Post getById(int id) {
        for(Post post : this.posts) {
            if(post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> getAll() {
        return this.posts;

    }

    @Override
    public void persist(Post post) {
        post.setId(++this.lastId);
        this.posts.add(post);
    }
}
