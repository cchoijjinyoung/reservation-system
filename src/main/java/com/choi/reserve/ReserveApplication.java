package com.choi.reserve;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ReserveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReserveApplication.class, args);
    }
}
