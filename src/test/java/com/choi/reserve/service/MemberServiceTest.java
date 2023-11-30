package com.choi.reserve.service;

import com.choi.reserve.constants.Role;
import com.choi.reserve.dto.Auth;
import com.choi.reserve.dto.SignupResponseDto;
import com.choi.reserve.entity.MemberEntity;
import com.choi.reserve.exception.CustomErrorStatus;
import com.choi.reserve.exception.CustomException;
import com.choi.reserve.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.choi.reserve.exception.CustomErrorStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Test
    void 회원가입_실패_이메일_중복() {
        String sameEmail = "user@gmail.com";
        // given
        MemberEntity user1 = MemberEntity.builder()
                .email(sameEmail)
                .password("1234")
                .nickname("nick")
                .phoneNumber("010-1111-2222")
                .role(Role.ROLE_USER)
                .build();

        memberRepository.save(user1);

        Auth.SignUp request = Auth.SignUp.builder()
                .email(sameEmail)
                .password("1234")
                .nickname("nick")
                .phoneNumber("010-1111-2222")
                .role(Role.ROLE_USER)
                .build();
        // when
        memberService.join(request);
        // then
        Assertions.assertThatThrownBy(
                () -> {
                    throw new CustomException(ALREADY_EXISTS_MEMBER);
                }
        );
    }

    @Test
    void 회원가입_성공_일반회원() {
        // given
        Auth.SignUp request = Auth.SignUp.builder()
                .email("user@gmail.com")
                .password("1234")
                .nickname("nick")
                .phoneNumber("010-1111-2222")
                .role(Role.ROLE_USER)
                .build();
        // when
        SignupResponseDto result = memberService.join(request);
        // then
        verify(memberRepository).save(any());
        assertThat(result.getNickname()).isEqualTo("nick");
        assertThat(result.getRole()).isEqualTo("회원");
    }

    @Test
    void 회원가입_성공_파트너() {
        // given
        Auth.SignUp request = Auth.SignUp.builder()
                .email("partner@gmail.com")
                .password("1234")
                .nickname("nick")
                .phoneNumber("010-1111-2222")
                .role(Role.ROLE_PARTNER)
                .build();
        // when
        SignupResponseDto result = memberService.join(request);
        // then
        verify(memberRepository).save(any());
        assertThat(result.getNickname()).isEqualTo("nick");
        assertThat(result.getRole()).isEqualTo("파트너");
    }
}