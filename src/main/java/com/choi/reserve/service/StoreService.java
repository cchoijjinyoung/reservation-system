package com.choi.reserve.service;

import com.choi.reserve.entity.StoreEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreEntity registerStore(StoreRegisterRequest request) {
        return storeRepository.save(StoreEntity.fromDto(request));
    }
}
