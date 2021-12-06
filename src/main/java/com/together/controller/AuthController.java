package com.together.controller;

import com.together.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @GetMapping("/signin")
    public String signin(){
        return "/auth/signin";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/auth/signup";
    }

    @PostMapping("/signup")
    public String post_signup(){



        return "redirect:/signin";
    }
}
