package com.uptempo.ams.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@RequestScope
@Component
public class IPAddressInterceptor implements HandlerInterceptor {

    private String ipAddress;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ipAddress = request.getHeader("X-Forward-For");
        if(Objects.isNull(ipAddress))
            ipAddress = request.getRemoteAddr();
        return true;
    }

    public String getIpAddress(){
        return ipAddress;
    }
}
