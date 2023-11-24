package com.choi.reserve.dto;

public class Auth {

    public static class SignUp {
        private String email;
        private String password;
        private String nickname;
        private String phoneNumber;
    }

    public static class SignIn {
        private String username;
        private String password;
    }
}
