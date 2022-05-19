package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import com.nhnacademy.jdbc.board.service.UserLoginService;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id")String userName, @RequestParam("pwd") String password, HttpServletRequest request){
       return userLoginService.loginService(userName,password,request);
    }

}
