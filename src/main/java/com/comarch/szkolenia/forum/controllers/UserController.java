package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.model.User;
import com.comarch.szkolenia.forum.services.IUserService;
import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.services.IPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final IPostService postService;

    @GetMapping("/edit-profile")
    public String editProfileForm(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        model.addAttribute("user", user);
        return "edit-profile";
    }

    @PostMapping("/edit-profile")
    public String editProfile(@ModelAttribute User formUser, @RequestParam("password") String password, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        user.setName(formUser.getName());
        user.setSurname(formUser.getSurname());
        if(password != null && !password.isEmpty()) {
            userService.changePassword(user.getId(), password);
        }
        userService.updateUser(user);
        session.setAttribute("user", user);
        return "redirect:/edit-profile";
    }

    @GetMapping("/my-posts")
    public String myPosts(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        List<Post> posts = postService.getAllPosts();
        List<Post> myPosts = new ArrayList<>();
        for(Post post : posts) {
            if(post.getAuthor().equals(user.getLogin())) {
                myPosts.add(post);
            }
        }
        model.addAttribute("posts", myPosts);
        return "my-posts";
    }

    @GetMapping("/edit-post/{id}")
    public String editPostForm(@PathVariable("id") int postId, HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        Optional<Post> postOpt = postService.getPostById(postId);
        if(postOpt.isEmpty() || !postOpt.get().getAuthor().equals(user.getLogin())) {
            return "redirect:/my-posts";
        }
        model.addAttribute("post", postOpt.get());
        return "edit-post";
    }

    @PostMapping("/edit-post/{id}")
    public String editPost(@PathVariable("id") int postId, @RequestParam("content") String content, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        Optional<Post> postOpt = postService.getPostById(postId);
        if(postOpt.isPresent() && postOpt.get().getAuthor().equals(user.getLogin())) {
            Post post = postOpt.get();
            post.setContent(content);
            postService.addPost(post);
        }
        return "redirect:/my-posts";
    }

    @PostMapping("/delete-post/{id}")
    public String deletePost(@PathVariable("id") int postId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null) {
            return "redirect:/login";
        }
        User user = (User) userObj;
        Optional<Post> postOpt = postService.getPostById(postId);
        if(postOpt.isPresent() && postOpt.get().getAuthor().equals(user.getLogin())) {
            postService.deletePost(postId);
        }
        return "redirect:/my-posts";
    }
}
