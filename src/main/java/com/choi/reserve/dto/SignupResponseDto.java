package com.choi.reserve.dto;

import lombok.Getter;

@Getter
public class SignupResponseDto {

    private String nickname;

    private String role;

    public SignupResponseDto(Auth.SignUp request) {
        this.nickname = request.getNickname();
        this.role = request.getRole().getDescription();
    }
}
