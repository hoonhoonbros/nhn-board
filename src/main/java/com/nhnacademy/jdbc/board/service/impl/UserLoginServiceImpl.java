package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.repository.UserLoginRepository;
import com.nhnacademy.jdbc.board.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserService {
    private final UserLoginRepository userLoginRepository;

    public UserLoginServiceImpl(
        UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public boolean doLogin(String userName, String password, HttpServletRequest request) {
        User user = userLoginRepository.findByUserName(userName).get();

        if (Objects.equals(user, null) || !Objects.equals(user.getPassword(), password)) {
            return false;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", userName);

        return true;
    }
}
