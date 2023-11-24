package com.choi.reserve.controller;

import com.choi.reserve.dto.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(Auth.SignUp request) {
        return null;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(Auth.SignIn request) {
        return null;
    }
}
