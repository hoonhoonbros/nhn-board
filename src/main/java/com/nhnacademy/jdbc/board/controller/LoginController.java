package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.UserLoginService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping("/login")
    public String goLoginForm(){
        return "users/login-form";
    }

    @PostMapping("/login")
    public String loginToBoard(@RequestParam("id")String userName, @RequestParam("pwd") String password, HttpServletRequest request){
       return userLoginService.doLogin(userName,password,request);
    }

}
