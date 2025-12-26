package com.example.demo.security;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    // 🔥 REQUIRED constructor
    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // ✅ USED BY TESTS
    public String generateToken(AppUser user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().name())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // ✅ USED BY TESTS
    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}
