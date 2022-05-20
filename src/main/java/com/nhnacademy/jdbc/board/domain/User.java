package com.nhnacademy.jdbc.board.domain;

import lombok.Value;

@Value
public class User {
    long id;
    String username;
    String password;
    String roleCode;
}
