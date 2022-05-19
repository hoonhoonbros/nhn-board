package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.User;
import java.util.Optional;

public interface UserMapper {
    Optional<User> SelectUser(String userName);
}
