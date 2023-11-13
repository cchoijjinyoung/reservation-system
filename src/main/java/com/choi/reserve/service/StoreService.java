package com.choi.reserve.service;

import com.choi.reserve.dto.RegisterStoreRequest;
import com.choi.reserve.dto.RegisterStoreResponse;
import com.choi.reserve.entity.StoreEntity;
import com.choi.reserve.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreEntity registerStore(RegisterStoreRequest request) {
        return storeRepository.save(StoreEntity.fromDto(request));
    }
}
