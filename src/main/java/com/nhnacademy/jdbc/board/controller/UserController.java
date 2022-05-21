package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String goLoginForm() {
        return "users/login-form";
    }

    @PostMapping("/login")
    public String loginToBoard(@RequestParam("username") String userName, @RequestParam("password") String password,
                               HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        boolean isLoginSuccess = userService.doLogin(userName, password, request);

        if (isLoginSuccess) {
            response.sendRedirect("/posts");
            return null;
        }
        response.sendRedirect("/users/login-form");
        return null;
    }

}
