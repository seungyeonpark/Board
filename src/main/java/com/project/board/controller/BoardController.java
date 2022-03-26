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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public String list(@ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        log.info("pageRequest = {}", pageRequest);

        Integer totalCount = service.count();
        Pagination pagination = new Pagination(totalCount, pageRequest);

        model.addAttribute("list", service.list(pageRequest));
        model.addAttribute("pagination", pagination);

        return "board/list";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("board", new Board());
        return "board/write";
    }

    @PostMapping("/register")
    public String register(@Validated Board board, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "board/write";
        }

        service.register(board);
        return "redirect:/board/list";
    }

    @GetMapping("/read/{boardNo}")
    public String read(@PathVariable Long boardNo, @ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        log.info("pageRequest = {}", pageRequest);

        model.addAttribute("board", service.read(boardNo));
        return "board/view";
    }

    @GetMapping("/modify/{boardNo}")
    public String modifyForm(@PathVariable Long boardNo, @ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        model.addAttribute("board", service.read(boardNo));
        return "board/edit";
    }

    @PostMapping("/modify/{boardNo}")
    public String modify(@PathVariable Long boardNo,
                         @Validated Board board,
                         BindingResult bindingResult,
                         @ModelAttribute PageRequest pageRequest,
                         RedirectAttributes redirectAttributes) throws Exception {

        if (bindingResult.hasErrors()) {
            return "board/edit";
        }

        board.setBoardNo(boardNo);
        service.modify(board);

        log.info("pageRequest = {}", pageRequest);
        redirectAttributes.addAttribute("page", pageRequest.getPage());

        return "redirect:/board/list";
    }

    @GetMapping("/remove/{boardNo}")
    public String remove(@PathVariable Long boardNo,
                         @ModelAttribute PageRequest pageRequest,
                         RedirectAttributes redirectAttributes) throws Exception {

        service.remove(boardNo);

        log.info("pageRequest = {}", pageRequest);
        redirectAttributes.addAttribute("page", pageRequest.getPage());

        return "redirect:/board/list";
    }
}
