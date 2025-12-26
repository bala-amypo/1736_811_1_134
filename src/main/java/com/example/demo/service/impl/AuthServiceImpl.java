package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;

public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AppUserRepository repository, JwtTokenProvider jwtTokenProvider) {
        this.repository = repository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        repository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new IllegalArgumentException("Email already exists");
                });

        AppUser user = AppUser.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        repository.save(user);
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("not found");
        }

        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole());
        return new AuthResponse(token);
    }
}
