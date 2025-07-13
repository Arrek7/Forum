package com.comarch.szkolenia.forum.services;

import com.comarch.szkolenia.forum.model.Post;
import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPosts();
    List<Post> getPostsByTopicId(int topicId);
    Optional<Post> getPostById(int id);
    void addPost(Post post);
    void deletePost(int id);
}
