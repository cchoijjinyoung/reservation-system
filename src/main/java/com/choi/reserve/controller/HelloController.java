package com.choi.reserve.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userHello() {
        return "USER hello";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello() {
        return "ADMIN hello";
    }
}
