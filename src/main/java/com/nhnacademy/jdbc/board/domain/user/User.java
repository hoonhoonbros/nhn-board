package com.nhnacademy.jdbc.board.domain.user;

import lombok.Value;

@Value
public class User {
    private final Integer userNo;
    private final String username;
    private final String password;
    private final String roleCode;
}
