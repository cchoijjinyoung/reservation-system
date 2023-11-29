package com.choi.reserve.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    // private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("----------configure-----------");

//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//
//        authenticationManagerBuilder
//                .userDetailsService(withDefaults())
//                .passwordEncoder(passwordEncoder());
//
//        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http
                .formLogin(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)

                .exceptionHandling(c -> c
                        .accessDeniedHandler(accessDeniedHandler()))

                .sessionManagement(c -> c
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//                .authenticationManager(authenticationManager);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info("----------web configure----------");

        // 정적 파일은 시큐리티 동작 무시.
        return (web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations()));
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}
