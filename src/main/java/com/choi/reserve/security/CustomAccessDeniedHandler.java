package com.choi.reserve.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    final String ERROR_STATUS = "ACCESS_DENIED";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //
        log.info("-----ACCESS DENIED-----");
        response.setStatus(HttpStatus.FORBIDDEN.value());

        String contentType = request.getHeader(HttpHeaders.CONTENT_TYPE);
        boolean isJson = contentType.startsWith("application/json");

        if (!isJson) {
            throw new RuntimeException("Access Denied error");
        }
    }
}