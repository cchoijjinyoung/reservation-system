package com.choi.reserve.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static jakarta.servlet.http.HttpServletResponse.*;

@AllArgsConstructor
@Getter
public enum CustomErrorStatus {

    UserNotFound(SC_NOT_FOUND, "존재히지 않는 회원입니다.");

    private final int code;

    private final String message;
}
