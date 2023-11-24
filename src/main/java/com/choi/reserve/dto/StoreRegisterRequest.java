package com.choi.reserve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreRegisterRequest {

    private String name;

    private Long managerId;

    private String location;

    private String description;
}
