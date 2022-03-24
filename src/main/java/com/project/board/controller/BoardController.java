package com.project.board.controller;

import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping(value = {"/", "/list"})
    public String list(Model model) throws Exception {

        model.addAttribute("list", service.list());
        return "list";
    }
}
