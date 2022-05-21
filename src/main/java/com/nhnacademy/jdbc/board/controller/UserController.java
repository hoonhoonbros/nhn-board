package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.impl.UserServiceImpl;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/login")
    public String goLoginForm(){
        return "users/login-form";
    }

    @PostMapping("/login")
    public String loginToBoard(@RequestParam("username")String userName, @RequestParam("password") String password,
                               HttpServletRequest request, HttpServletResponse response)
        throws IOException {
       boolean isLoginSuccess = userServiceImpl.doLogin(userName,password,request);

       if(isLoginSuccess){
           response.sendRedirect("/posts");
           return null;
       }
        response.sendRedirect("/users/login-form");
            return null;
    }

}
