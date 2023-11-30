package com.choi.reserve.controller;

import com.choi.reserve.dto.Auth;
import com.choi.reserve.dto.SignupResponseDto;
import com.choi.reserve.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid Auth.SignUp request) {
        SignupResponseDto response = memberService.join(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(Auth.SignIn request) {
        return null;
    }
}
