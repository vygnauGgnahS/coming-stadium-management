package com.situ.stadium.commen;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.situ.stadium.util.JwtUtils;
import com.situ.stadium.util.WebAppUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    private final String jwtSecretKey;

    public JwtInterceptor(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        String jwt = req.getHeader("jwt");

        try {
            DecodedJWT dj = JwtUtils.decode(jwt, jwtSecretKey);
            return true;
        } catch (Exception e) {
            WebAppUtils.writeJson(resp, Map.of("code", 401, "msg", "jwt无效"));
            return false;
        }
    }
}
