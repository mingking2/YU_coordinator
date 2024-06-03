package com.project.yucoordinator.domain.user.controller;

import com.project.yucoordinator.domain.user.dto.LoginForm;
import com.project.yucoordinator.domain.user.dto.SignupForm;
import com.project.yucoordinator.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("request", new SignupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute SignupForm req) {
        userService.save(req);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm")LoginForm loginForm) {
        return "login";
    }

}
