package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.UserLoginService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserLoginService userLoginService;

    public UserController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping("/login")
    public String goLoginForm(){
        return "users/login-form";
    }

    @PostMapping("/login")
    public String loginToBoard(@RequestParam("username")String userName, @RequestParam("password") String password, HttpServletRequest request){
       return userLoginService.doLogin(userName,password,request);
    }

}
