package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import com.choi.reserve.contrants.ApprovalStatus;
import com.choi.reserve.contrants.VisitStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class reservationEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    private ApprovalStatus approvalStatus;

    @Column(nullable = false)
    private VisitStatus visitStatus;
}
