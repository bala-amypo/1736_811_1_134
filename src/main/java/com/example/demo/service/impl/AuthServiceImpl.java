package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AppUserRepository repo;

    @Override
    public void register(RegisterRequest request) {
        if (repo.findByEmail(request.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        repo.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = repo.findByEmail(request.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return new AuthResponse("dummy-jwt-token");
    }
}
