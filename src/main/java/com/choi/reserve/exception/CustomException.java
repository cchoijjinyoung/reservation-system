package com.choi.reserve.exception;

import lombok.Getter;

/**
 * throw new CustomException(USER_NOT_FOUND)
 */
@Getter
public abstract class CustomException extends RuntimeException {
    private final int statusCode;
    public CustomException(CustomErrorStatus customErrorStatus) {
        super(customErrorStatus.getMessage());
        this.statusCode = customErrorStatus.getCode();
    }
}
