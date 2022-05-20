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

    public String doLogin(String userName, String password, HttpServletRequest request) {
        User user = userLoginRepository.findByUserName(userName).get();

        if (Objects.equals(user, null) || !Objects.equals(user.getPassword(), password)) {
            return "users/login-form";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", userName);

        return "index/index";
    }
}
