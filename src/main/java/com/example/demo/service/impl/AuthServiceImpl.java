package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    public AuthServiceImpl() {
    }

    @Override
    public void register(RegisterRequest request) {
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-token");
    }
}
