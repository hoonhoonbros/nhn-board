package com.nhnacademy.jdbc.board.domain;

import lombok.Value;

@Value
public class User {
    Integer userNo;
    String username;
    String password;
    String roleCode;
}
