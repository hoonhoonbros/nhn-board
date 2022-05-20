package com.nhnacademy.jdbc.board.domain;

import lombok.Value;

@Value
public class User {
    int userNo;
    String username;
    String password;
    String roleCode;
}
