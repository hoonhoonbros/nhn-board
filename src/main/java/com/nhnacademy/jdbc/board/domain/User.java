package com.nhnacademy.jdbc.board.domain;

import lombok.Value;

@Value
public class User {
    private long username;
    private String password;
    private String role_code;
}
