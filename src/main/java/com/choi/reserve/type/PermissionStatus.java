package com.choi.reserve.type;

import lombok.AllArgsConstructor;

/**
 * 예약승인 상태
 */
@AllArgsConstructor
public enum PermissionStatus {
    WAITING("대기중"),
    GRANTED("승인"),
    DENIED("거절");

    private String status;
}
