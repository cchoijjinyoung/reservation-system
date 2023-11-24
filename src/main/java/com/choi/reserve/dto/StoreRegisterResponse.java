package com.choi.reserve.dto;

import com.choi.reserve.entity.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreRegisterResponse {

    private String name;

    private Long managerId;

    private String location;

    private String description;

    public static StoreRegisterResponse fromEntity(StoreEntity entity) {
        return StoreRegisterResponse.builder()
                .name(entity.getName())
                .managerId(entity.getManagerId())
                .location(entity.getLocation())
                .description(entity.getDescription())
                .build();
    }
}

