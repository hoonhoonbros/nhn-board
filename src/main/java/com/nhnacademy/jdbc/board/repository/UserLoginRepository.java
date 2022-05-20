package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.domain.User;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginRepository {
    private final UserMapper userMapper;

    public UserLoginRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(String userName){

        return userMapper.selectUser(userName);
    }
}
