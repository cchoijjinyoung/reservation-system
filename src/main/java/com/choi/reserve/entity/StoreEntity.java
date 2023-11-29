package com.choi.reserve.entity;

import com.choi.reserve.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "STORE")
public class StoreEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long managerId;

    @Column(nullable = false, unique = true)
    private String location;

    @Column(length = 100)
    private String description;
}
