package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.user.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserName(String userName);
}
