package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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
    private String permissionStatus;

    @Column(nullable = false)
    private String visitStatus;
}
