package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(User user) {
        return jwtTokenProvider.createToken(
                user.getEmail(),
                user.getRole()
        );
    }

    @Override
    public String register(User user) {
        return jwtTokenProvider.createToken(
                user.getEmail(),
                user.getRole()
        );
    }
}
