package com.choi.reserve.service;

import com.choi.reserve.dto.Auth;
import com.choi.reserve.dto.SignupResponseDto;
import com.choi.reserve.entity.MemberEntity;
import com.choi.reserve.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public SignupResponseDto join(Auth.SignUp request) {

        MemberEntity memberEntity = MemberEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .build();
        memberRepository.save(memberEntity);

        return new SignupResponseDto(request);
    }
}
