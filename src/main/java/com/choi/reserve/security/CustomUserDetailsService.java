package com.choi.reserve.security;

import com.choi.reserve.entity.MemberEntity;
import com.choi.reserve.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername = {}", username);

//        MemberEntity memberEntity = memberRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("username not Found"));

        UserDetails userDetails = User.withUsername("user")
                .password("1111")
                .roles("ADMIN", "USER")
                .build();


        return userDetails;
    }
}
