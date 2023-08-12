package com.librarySystem.RestAPI.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public PasswordEncoder getEncoder() {

        return new BCryptPasswordEncoder(11);
    }
}
