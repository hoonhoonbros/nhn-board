package com.nhnacademy.jdbc.board.service;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.repository.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserLoginService {
    private final UserLoginRepository userLoginRepository;

    public String doLogin(String username, String password, HttpServletRequest request) {
        User user = userLoginRepository.findByUserName(username).get();

        if (!isValidAccount(password, user)) {
            return "users/login-form";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);

        return "redirect:/posts";
    }

    private boolean isValidAccount(String password, User user) {
        return isNull(user) || !Objects.equals(user.getPassword(), password);
    }
}
