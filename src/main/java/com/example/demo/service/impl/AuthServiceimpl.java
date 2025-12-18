package com.example.demo.Service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.Service.AuthService;

@Service
public class AuthServiceimpl implements AuthService {

    public AuthServiceimpl() {
    }

    @Override
    public void register(RegisterRequest request) {
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-token");
    }
}
