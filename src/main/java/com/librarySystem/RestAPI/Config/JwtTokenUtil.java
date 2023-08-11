//package com.librarySystem.RestAPI.Config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.Objects;
//
//@Component
//public class JwtTokenUtil {
//    private final String secret = "secret";
//
//    private String generateToken(Map<String, Object> claims) {
//        Date expirationDate = new Date(System.currentTimeMillis()+2592000L*1000);
//        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS256, secret).compact();
//    }
//
//    private Claims getClaimsFromTocken(String token) {
//        Claims claims;
//        try {
//            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//        } catch (Exception e) {
//            claims = null;
//        }
//        return claims;
//    }
//}
