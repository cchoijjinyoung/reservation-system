package com.choi.reserve.constants;

import lombok.AllArgsConstructor;

/**
 * 예약승인 상태
 */
@AllArgsConstructor
public enum ApprovalStatus {
    WAITING("대기중"),
    APPROVED("승인"),
    DISAPPROVED("거절");

    private final String description;
}
