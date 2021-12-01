package com.together.controller;

import com.together.auth.email.EmailService;
import com.together.dto.request.CreateCategoryRequest;
import com.together.service.BoardService;
import com.together.service.CategoryService;
import com.together.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final EmailService emailService;
    private final BoardService boardService;
    private final CategoryService categoryService;
    private final MemberService memberService;

    @GetMapping("/")
    public String test(){
        return "/test";
    }

    @PostMapping("/category")
    public String createCategory(String categoryName){
        log.info("category post 호출");
        categoryService.createCategory(categoryName);

        return "redirect:/";
    }

    @PostMapping("/mail")
    @ResponseBody
    public void emailConfirm(String userId)throws Exception{
        log.info("userId={}", userId);
        log.info("post emailConfirm");
        System.out.println("전달 받은 이메일 : "+userId);
        emailService.sendSimpleMessage(userId);
    }

    @PostMapping("/verifyCode")
    @ResponseBody
    public int verifyCode(String code) {
        log.info("Post verifyCode");

        int result = 0;
        System.out.println("code : "+code);
        System.out.println("code match : "+ EmailService.ePw.equals(code));
        if(EmailService.ePw.equals(code)) {
            result =1;
        }

        return result;
    }
}
