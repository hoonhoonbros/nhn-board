package com.nhnacademy.jdbc.board.service.impl;

import static java.util.Objects.nonNull;

import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import com.nhnacademy.jdbc.board.service.UserService;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public boolean doLogin(String username, String password, HttpServletRequest request) {
        Optional<User> user = userRepository.findByUserName(username);

        if (user.isEmpty()) {
            return false;
        }

        if (!isValidAccount(user.get(), password)) {
            return false;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);

        return true;

    }

    private boolean isValidAccount(User user, String password) {
        return nonNull(user) && Objects.equals(user.getPassword(), password);
    }
}
