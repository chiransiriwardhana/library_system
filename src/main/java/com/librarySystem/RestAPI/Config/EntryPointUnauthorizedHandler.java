//package com.librarySystem.RestAPI.Config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import org.springframework.security.core.AuthenticationException;
//import java.io.IOException;
//
//@Component
//public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setStatus(401);
//    }
//}
