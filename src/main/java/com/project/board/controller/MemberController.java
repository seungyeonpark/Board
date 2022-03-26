package com.project.board.controller;

import com.project.board.domain.Member;
import com.project.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/login")
    public String loginForm(@RequestParam(defaultValue="/") String redirectURL, Model model) {

        model.addAttribute("member", new Member());
        model.addAttribute("redirectURL", redirectURL);

        return "member/login";
    }

    @PostMapping("/login")
    public String login(@Validated Member member,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue="/") String redirectURL,
                        HttpServletRequest request) throws Exception {

        log.info("member = {}", member);
        log.info("redirectURL = {}", redirectURL);
        log.info("bindingResult = {}", bindingResult);

        if (bindingResult.hasErrors()) {
            return "member/login";
        }

        Member loginMember = service.login(member);

        log.info("loginMember = {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "member/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        return "redirect:" + redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
