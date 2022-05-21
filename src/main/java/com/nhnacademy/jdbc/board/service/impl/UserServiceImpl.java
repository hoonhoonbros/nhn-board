package com.nhnacademy.jdbc.board.service.impl;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import com.nhnacademy.jdbc.board.repository.impl.UserRepositoryImpl;
import com.nhnacademy.jdbc.board.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public boolean doLogin(String userName, String password, HttpServletRequest request) {
        User user = userRepository.findByUserName(userName).get();

        if (Objects.equals(user, null) || !Objects.equals(user.getPassword(), password)) {
            return false;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", userName);

        return true;
    }
}
