package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class StoreEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String location;

    @Column(length = 100)
    private String description;
}
