package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.model.User;
import com.comarch.szkolenia.forum.model.Post;
import com.comarch.szkolenia.forum.services.IUserService;
import com.comarch.szkolenia.forum.services.IPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ModeratorController {
    private final IUserService userService;
    private final IPostService postService;

    @GetMapping("/moderator-panel")
    public String moderatorPanel(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || (((User)userObj).getRole() != User.Role.MODERATOR && ((User)userObj).getRole() != User.Role.ADMIN)) {
            return "redirect:/main";
        }
        model.addAttribute("users", userService.getAll());
        model.addAttribute("posts", postService.getAllPosts());
        return "moderator-panel";
    }

    @PostMapping("/ban-user/{id}")
    public String banUser(@PathVariable("id") int userId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || (((User)userObj).getRole() != User.Role.MODERATOR && ((User)userObj).getRole() != User.Role.ADMIN)) {
            return "redirect:/main";
        }
        userService.banUser(userId);
        return "redirect:/moderator-panel";
    }

    @PostMapping("/unban-user/{id}")
    public String unbanUser(@PathVariable("id") int userId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || (((User)userObj).getRole() != User.Role.MODERATOR && ((User)userObj).getRole() != User.Role.ADMIN)) {
            return "redirect:/main";
        }
        userService.unbanUser(userId);
        return "redirect:/moderator-panel";
    }

    @PostMapping("/moderator-delete-post/{id}")
    public String deletePost(@PathVariable("id") int postId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || (((User)userObj).getRole() != User.Role.MODERATOR && ((User)userObj).getRole() != User.Role.ADMIN)) {
            return "redirect:/main";
        }
        postService.deletePost(postId);
        return "redirect:/moderator-panel";
    }
}

