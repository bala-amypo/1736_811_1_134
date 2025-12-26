package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private String role; // test uses role as String, like UserRole.CLINICIAN
}
