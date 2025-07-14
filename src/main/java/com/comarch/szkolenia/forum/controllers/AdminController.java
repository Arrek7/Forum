package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.model.User;
import com.comarch.szkolenia.forum.services.IUserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final IUserService userService;

    @GetMapping("/admin-panel")
    public String adminPanel(HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || ((User)userObj).getRole() != User.Role.ADMIN) {
            return "redirect:/main";
        }
        model.addAttribute("users", userService.getAll());
        return "admin-panel";
    }

    @PostMapping("/admin-promote/{id}")
    public String promoteToModerator(@PathVariable("id") int userId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || ((User)userObj).getRole() != User.Role.ADMIN) {
            return "redirect:/main";
        }
        userService.changeRole(userId, User.Role.MODERATOR);
        return "redirect:/admin-panel";
    }

    @PostMapping("/admin-demote/{id}")
    public String demoteModerator(@PathVariable("id") int userId, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if(userObj == null || ((User)userObj).getRole() != User.Role.ADMIN) {
            return "redirect:/main";
        }
        userService.changeRole(userId, User.Role.USER);
        return "redirect:/admin-panel";
    }
}
