package com.comarch.szkolenia.forum.services.impl;

import com.comarch.szkolenia.forum.dao.IPostDAO;
import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.services.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final IPostDAO postDAO;

    public List<Post> getAllPosts() {
        return postDAO.getAll();
    }

    public List<Post> getPostsByTopicId(int topicId) {
        return postDAO.getAllByTopicId(topicId);
    }

    public Optional<Post> getPostById(int id) {
        return postDAO.getById(id);
    }

    public void addPost(Post post) {
        postDAO.persist(post);
    }
}
