package com.nhnacademy.jdbc.board.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userNo;
    private String username;
    private String password;
    private String roleCode;
}
