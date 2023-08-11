//package com.librarySystem.RestAPI.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SpringSecurityConfig {
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//
//    @Autowired
//    EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;
//
//    @Autowired
//    RestAccessDeniedHandler restAccessDeniedHandler;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers()
//    }
//
//
//    @Bean
//    public PasswordEncoder getEncoder() {
//        return new BCryptPasswordEncoder(11);
//    }
//}
