package com.choi.reserve.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static jakarta.servlet.http.HttpServletResponse.SC_CONFLICT;
import static jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@AllArgsConstructor
@Getter
public enum CustomErrorStatus {

    USER_NOT_FOUND(SC_NOT_FOUND, "존재히지 않는 회원입니다."),
    ALREADY_EXISTS_MEMBER(SC_CONFLICT, "이미 존재하는 회원입니다.");

    private final int code;

    private final String message;
}
