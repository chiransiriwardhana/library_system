//package com.librarySystem.RestAPI.Config;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.hibernate.annotations.DialectOverride;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//
//    private UserDetailsService userDetailsService;
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    public JwtAuthenticationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
//        this.userDetailsService = userDetailsService;
//        this.jwtTokenUtil = jwtTokenUtil;
//    }
//
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        String tokenHead = "Bearer";
//
//        if(authHeader != null && authHeader.startsWith(tokenHead)) {
//            String authTocken = authHeader.substring(tokenHead.length());
//            String username = jwtTokenUtil.getUsernameFromToken(authTocken);
//            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//                boolean isValidJwtToken = jwtTokenUtil.validateTocken(authTocken, userDetails);
//                if(isValidJwtToken) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
