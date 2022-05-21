package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUserName(String userName);
}
