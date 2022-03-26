package com.project.board.controller;

import com.project.board.domain.Member;
import com.project.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("member", new Member());
        return "member/join";
    }

    @PostMapping("/register")
    public String register (Member member, Model model) throws Exception {

        log.info("member = {}", member);

        service.register(member);

        return "redirect:/";
    }
}
