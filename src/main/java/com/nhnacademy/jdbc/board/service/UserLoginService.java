package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.repository.UserLoginRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    private final UserLoginRepository userLoginRepository;

    public UserLoginService(
        UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public String loginService(String userName, String password, HttpServletRequest request){
        User user = userLoginRepository.getUser(userName);

        if(Objects.equals(user.getPassword(), password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("id", userName);
            return "index/index";
        }
        return "user/loginForm";
    }
}
