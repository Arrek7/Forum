package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.dao.impl.memory.PostRepository;
import com.comarch.szkolenia.forum.dao.impl.memory.TopicRepository;
import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/*@Controller
public class ForumController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/main")
    public String forum (Model model) {
        List<Topic> topics = topicRepository.getAll();
        List<Post> posts = postRepository.getAll();

        for(Topic topic : topics) {
            List<Post> topicPosts = new ArrayList<>();
            for(Post post : posts) {
                if(post.getTopicId() == topic.getId()) {
                    topicPosts.add(post);
                }
            }
            topic.setPosts(topicPosts);
        }
        model.addAttribute("topics", topics);
        return "main";
    }
}*/