package com.nhnacademy.jdbc.board.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    boolean doLogin(String userName, String password, HttpServletRequest request);
}
