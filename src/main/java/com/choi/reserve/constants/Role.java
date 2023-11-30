package com.choi.reserve.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ROLE_USER("회원"),
    ROLE_PARTNER("파트너")
    ;

    private final String description;
}
