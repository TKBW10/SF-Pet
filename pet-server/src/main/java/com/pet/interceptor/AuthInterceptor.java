package com.pet.interceptor;

import com.pet.context.BaseContext;
import com.pet.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token == null || !JwtUtil.validateToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("登录过期，请重新登录");
            return false;
        }

        Claims claims = JwtUtil.parseToken(token);
        String phoneNumber = claims.get("phoneNumber", String.class);
        BaseContext.setCurrentId(phoneNumber);

        return true;
    }
}
