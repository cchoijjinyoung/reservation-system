package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class MemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;
}
