package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PatientProfile {
    private Long id;
    private String patientId; // must match test
    private String fullName;
    private Integer age;
    private String email;
    private String surgeryType;
    private Boolean active; // test uses getActive()
    private LocalDateTime createdAt;
}
