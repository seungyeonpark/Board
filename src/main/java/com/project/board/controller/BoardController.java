package com.project.board.controller;

import com.project.board.domain.Board;
import com.project.board.domain.PageRequest;
import com.project.board.domain.Pagination;
import com.project.board.domain.SearchTypeCodeValue;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public String list(@ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        log.info("pageRequest = {}", pageRequest);

        Integer totalCount = service.count(pageRequest);

        Pagination pagination = new Pagination(totalCount, pageRequest);

        List<SearchTypeCodeValue> searchTypeCodeValueList = SearchTypeCodeValue.getSearchTypeCodeValueList();

        model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
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
    public String register(@Validated Board board, BindingResult bindingResult, MultipartFile file) throws Exception {

        if (bindingResult.hasErrors()) {
            return "board/write";
        }

        service.register(board, file);

        return "redirect:/board/list";
    }

    @GetMapping("/read/{boardNo}")
    public String read(@PathVariable Long boardNo, @ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        log.info("pageRequest = {}", pageRequest);

        model.addAttribute("board", service.read(boardNo));
        return "board/view";
    }

    @GetMapping("/modify")
    public String modifyForm(@RequestParam Long boardNo, @ModelAttribute PageRequest pageRequest, Model model) throws Exception {

        log.info("pageRequest = {}", pageRequest);

        model.addAttribute("board", service.read(boardNo));
        return "board/edit";
    }

    @PostMapping("/modify")
    public String modify(@Validated Board board,
                         BindingResult bindingResult,
                         @ModelAttribute PageRequest pageRequest,
                         MultipartFile file,
                         RedirectAttributes redirectAttributes) throws Exception {

        log.info("board = {}", board);
        log.info("pageRequest = {}", pageRequest);

        if (bindingResult.hasErrors()) {
            return "board/edit";
        }

        service.modify(board, file);

        redirectAttributes.addAttribute("page", pageRequest.getPage());
        redirectAttributes.addAttribute("searchType", pageRequest.getSearchType());
        redirectAttributes.addAttribute("keyword", pageRequest.getKeyword());

        return "redirect:/board/list";
    }

    @GetMapping("/remove/{boardNo}")
    public String remove(@PathVariable Long boardNo,
                         @ModelAttribute PageRequest pageRequest,
                         RedirectAttributes redirectAttributes) throws Exception {

        service.remove(boardNo);

        redirectAttributes.addAttribute("page", pageRequest.getPage());
        redirectAttributes.addAttribute("searchType", pageRequest.getSearchType());
        redirectAttributes.addAttribute("keyword", pageRequest.getKeyword());

        return "redirect:/board/list";
    }
}
