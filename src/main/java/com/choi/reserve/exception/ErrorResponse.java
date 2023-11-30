package com.choi.reserve.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorResponse {

    private final int code;

    private final String message;

    // TODO: refactoring
    private final Map<String, String> validation = new HashMap<>();

    @Builder
    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void addValidation(String field, String defaultMessage) {
        validation.put(field, defaultMessage);
    }
}
