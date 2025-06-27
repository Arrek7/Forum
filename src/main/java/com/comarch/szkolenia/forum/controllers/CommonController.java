package com.comarch.szkolenia.forum.controllers;

import com.comarch.szkolenia.forum.dao.ITopicDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CommonController {
    private final ITopicDAO topicDAO;

    @GetMapping({"/main", "/", "/index"})
    public String main(Model model) {
        model.addAttribute("topics", this.topicDAO.getAll());
        return "main";
    }
}
