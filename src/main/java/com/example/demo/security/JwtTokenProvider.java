package com.example.demo.security;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // Generate a simple token string for testing purposes
    public String generateToken(AppUser user) {
        return "jwt-token-" + user.getEmail();
    }

    // Validate the token string (for test cases)
    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token");
    }
}
