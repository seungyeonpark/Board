package com.project.board.controller;

import com.project.board.domain.Board;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/register")
    public String registerForm(Board board, Model model) {

        model.addAttribute("board", board);
        return "write";
    }

    @PostMapping("/register")
    public String register(Board board) throws Exception {

        service.register(board);
        return "redirect:/board/list";
    }

    @GetMapping("/read/{boardNo}")
    public String read(@PathVariable Long boardNo, Model model) throws Exception {

        model.addAttribute("board", service.read(boardNo));
        return "view";
    }

    @GetMapping("/modify/{boardNo}")
    public String modifyForm(@PathVariable Long boardNo, Model model) throws Exception {

        model.addAttribute("board", service.read(boardNo));
        return "edit";
    }

    @PostMapping("/modify/{boardNo}")
    public String modify(@PathVariable Long boardNo, Board board) throws Exception {

        board.setBoardNo(boardNo);
        service.modify(board);

        return "redirect:/board/list";
    }

    @GetMapping("/remove/{boardNo}")
    public String remove(@PathVariable Long boardNo) throws Exception {

        service.remove(boardNo);
        return "redirect:/board/list";
    }
}
