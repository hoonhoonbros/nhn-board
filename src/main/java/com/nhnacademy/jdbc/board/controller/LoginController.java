package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserMapper userMapper;

    public LoginController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String goLoginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id")String userName, @RequestParam("pwd") String password){
        String resultUserName = String.valueOf(userMapper.SelectUser(userName));

        if(resultUserName.equals(userName)){
            return "/";
        }
        return "loginForm";
    }

}
