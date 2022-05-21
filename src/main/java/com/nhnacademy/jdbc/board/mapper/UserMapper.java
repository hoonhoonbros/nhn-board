package com.nhnacademy.jdbc.board.mapper;

import com.nhnacademy.jdbc.board.domain.user.User;
import java.util.Optional;


public interface UserMapper {
    Optional<User> selectUser(String userName);
    void insertUser();
}
