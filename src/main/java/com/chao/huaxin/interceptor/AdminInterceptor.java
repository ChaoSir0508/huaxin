package com.chao.huaxin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object session = request.getSession().getAttribute("user");
        if (session != null && session.equals("chaosir")) {
            return true;
        }
        response.sendRedirect("/admin");
        return false;
    }
}
