package com.choi.reserve.dto;

import com.choi.reserve.contrants.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class Auth {

    @Getter
    public static class SignUp {

        @NotBlank(message = "이메일을 입력해주세요.")
        private String email;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

        @NotBlank(message = "닉네임을 입력해주세요.")
        private String nickname;

        @NotBlank(message = "전화번호를 입력해주세요.")
        private String phoneNumber;

        @NotNull
        private Role role;
    }

    @Getter
    public static class SignIn {
        private String username;
        private String password;
    }
}
