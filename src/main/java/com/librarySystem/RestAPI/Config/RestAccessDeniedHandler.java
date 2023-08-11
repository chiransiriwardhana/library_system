//package com.librarySystem.RestAPI.Config;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.nio.file.AccessDeniedException;
//@Component
//public class RestAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setStatus(403);
//    }
//}
