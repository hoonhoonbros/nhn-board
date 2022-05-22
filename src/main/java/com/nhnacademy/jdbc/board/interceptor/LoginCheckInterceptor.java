package com.nhnacademy.jdbc.board.interceptor;

import static java.util.Objects.isNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if (isNull(request.getSession(false))) {
            response.sendRedirect("login");
            return false;
        }

        return true;
    }
}
