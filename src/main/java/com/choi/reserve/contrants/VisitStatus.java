package com.choi.reserve.contrants;

import lombok.AllArgsConstructor;

/**
 * 방문 상태
 */
@AllArgsConstructor
public enum VisitStatus {
    WAITING("대기 중"),
    COMPLETED("방문 완료");

    private String status;
}
