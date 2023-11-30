package com.choi.reserve.service;

import com.choi.reserve.dto.Auth;
import com.choi.reserve.dto.SignupResponseDto;
import com.choi.reserve.entity.MemberEntity;
import com.choi.reserve.exception.CustomException;
import com.choi.reserve.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.choi.reserve.exception.CustomErrorStatus.ALREADY_EXISTS_MEMBER;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public SignupResponseDto join(Auth.SignUp request) {
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException(ALREADY_EXISTS_MEMBER);
        }

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
