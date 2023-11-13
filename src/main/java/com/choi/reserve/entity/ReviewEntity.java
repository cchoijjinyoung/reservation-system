package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class ReviewEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(length = 100)
    private String content;
}
