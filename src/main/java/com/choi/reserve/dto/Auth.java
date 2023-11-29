package com.choi.reserve.dto;

import com.choi.reserve.contrants.Role;

public class Auth {

    public static class SignUp {
        private String email;
        private String password;
        private String nickname;
        private String phoneNumber;
        private Role role;
    }

    public static class SignIn {
        private String username;
        private String password;
    }
}
