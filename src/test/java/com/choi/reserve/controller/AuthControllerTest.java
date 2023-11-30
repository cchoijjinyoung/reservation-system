package com.choi.reserve.controller;

import com.choi.reserve.constants.Role;
import com.choi.reserve.dto.Auth;
import com.choi.reserve.security.SecurityConfig;
import com.choi.reserve.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = AuthController.class,
        excludeAutoConfiguration = SecurityAutoConfiguration.class, // 추가
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)}
)
class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @Autowired
    ObjectMapper objectMapper;

    void createUser() {
        Auth.SignUp user = Auth.SignUp.builder()
                .email("user1@gmail.com")
                .password("1234")
                .nickname("nick")
                .phoneNumber("010-1111-2222")
                .role(Role.ROLE_USER)
                .build();
    }


    @Test
    void 회원가입_실패_validation() throws Exception {
        // given
        Auth.SignUp user = Auth.SignUp.builder()
                .email("")
                .password("")
                .nickname("")
                .phoneNumber("")
                .role(Role.ROLE_USER)
                .build();

        // when
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(jsonPath("$.validation.email").value("이메일을 입력해주세요."))
                .andExpect(jsonPath("$.validation.password").value("비밀번호를 입력해주세요."))
                .andExpect(jsonPath("$.validation.nickname").value("닉네임을 입력해주세요."))
                .andExpect(jsonPath("$.validation.phoneNumber").value("전화번호를 입력해주세요."))
                .andDo(print());
    }

}