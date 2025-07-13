package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.comarch.szkolenia.forum.services.ITopicService;
import com.comarch.szkolenia.forum.services.IPostService;

@Controller
@RequiredArgsConstructor
public class CommonController {
    private final ITopicService topicService;
    private final IPostService postService;

    @GetMapping({"/main" , "/", "/index"})
    public String main(Model model) {
        List<Topic> topics = topicService.getAllTopics();
        List<Post> posts = postService.getAllPosts();
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

    @GetMapping("/FAQ")
    public String FAQ() {
        return "FAQ";
    }

    @PostMapping("/dodaj-temat")
    public String addTopic(@RequestParam("title") String title, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || title == null || title.trim().isEmpty()) {
            return "redirect:/main";
        }
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setAuthor(((com.comarch.szkolenia.forum.model.User)userObj).getLogin());
        topic.setCreationDate(LocalDate.now().toString());
        topic.setPosts(new ArrayList<>());
        topicService.addTopic(topic);
        return "redirect:/main";
    }

    @GetMapping("/temat/{id}")
    public String topic(@PathVariable("id") int id, Model model) {
        Optional<Topic> topicOpt = topicService.getTopicById(id);
        if(topicOpt.isEmpty()) {
            return "redirect:/main";
        }
        Topic topic = topicOpt.get();
        List<Post> posts = postService.getPostsByTopicId(id);
        topic.setPosts(posts);
        model.addAttribute("topic", topic);
        model.addAttribute("posts", posts);
        return "topic";
    }

    @PostMapping("/dodaj-post/{id}")
    public String addPost(@PathVariable("id") int topicId, @RequestParam("content") String content, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || content == null || content.trim().isEmpty()) {
            return "redirect:/temat/" + topicId;
        }
        Post post = new Post();
        post.setTopicId(topicId);
        post.setAuthor(((com.comarch.szkolenia.forum.model.User)userObj).getLogin());
        post.setContent(content);
        post.setCreationDate(java.time.LocalDate.now().toString());
        postService.addPost(post);
        return "redirect:/temat/" + topicId;
    }
}
