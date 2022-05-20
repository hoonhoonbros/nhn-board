package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginRepository {
    private final UserMapper userMapper;

    public UserLoginRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Optional<User> findByUserName(String userName){

        return userMapper.selectUser(userName);
    }
}
