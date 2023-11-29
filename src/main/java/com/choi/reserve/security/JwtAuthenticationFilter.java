package com.choi.reserve.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // request에서 token을 가져온다.
        String token = getTokenFromRequest(request);

        // token 검증



    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_HEADER);
        if (StringUtils.hasText(token) && token.startsWith(TOKEN_PREFIX)) {
            return token.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
