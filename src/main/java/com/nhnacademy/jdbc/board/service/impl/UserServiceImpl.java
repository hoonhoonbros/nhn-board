package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.repository.UserLoginRepository;
import com.nhnacademy.jdbc.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserLoginRepository userLoginRepository;

    public boolean doLogin(String username, String password, HttpServletRequest request) {
        User user = userLoginRepository.findByUserName(username).get();

        if (!isValidAccount(password, user)) {
            return false;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);

        return true;
    }

    private boolean isValidAccount(String password, User user) {
        return nonNull(user) || Objects.equals(user.getPassword(), password);
    }
}
