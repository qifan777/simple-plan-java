package com.jcheng.system.config;

import cn.dev33.satoken.stp.StpUtil;
import com.jcheng.common.annotation.JWTIgnore;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println(handlerMethod);
            if (!handlerMethod.hasMethodAnnotation(JWTIgnore.class)) {
                StpUtil.checkLogin();
            }
        }

        return true;
    }
}
