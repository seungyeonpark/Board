package com.project.board.controller;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;
import com.project.board.domain.Pagination;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public String list(@ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        model.addAttribute("list", service.list(pageRequest));

        log.info("pageRequest = {}", pageRequest);

        Pagination pagination = new Pagination();
        pagination.setPageRequest(pageRequest);
        pagination.setTotalCount(service.count());

        model.addAttribute("pagination", pagination);

        return "list";
    }

    @GetMapping("/register")
    public String registerForm(Board board, Model model) {

        model.addAttribute("board", board);
        return "write";
    }

    @PostMapping("/register")
    public String register(@Validated Board board, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "write";
        }

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
    public String modify(@PathVariable Long boardNo, @Validated Board board, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "edit";
        }

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
