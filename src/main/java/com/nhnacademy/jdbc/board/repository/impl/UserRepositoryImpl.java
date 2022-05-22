package com.nhnacademy.jdbc.board.repository.impl;

import com.nhnacademy.jdbc.board.domain.user.User;
import com.nhnacademy.jdbc.board.mapper.UserMapper;
import com.nhnacademy.jdbc.board.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByUserName(String username) {

        return userMapper.selectUser(username);
    }
}
