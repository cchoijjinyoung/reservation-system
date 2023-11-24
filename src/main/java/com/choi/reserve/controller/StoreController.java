package com.choi.reserve.controller;

import com.choi.reserve.dto.StoreRegisterRequest;
import com.choi.reserve.dto.StoreRegisterResponse;
import com.choi.reserve.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/store")
    public ResponseEntity<?> registerStore(@RequestBody StoreRegisterRequest request) {
        var result = storeService.registerStore(request);
        return ResponseEntity.ok(StoreRegisterResponse.fromEntity(result));
    }
}
