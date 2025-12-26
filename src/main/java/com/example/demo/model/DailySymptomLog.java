package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class DailySymptomLog {
    private Long id;
    private Long patientId; // test uses patientId (not PatientProfile)
    private LocalDate logDate;
    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;
    private String additionalNotes; // test uses additionalNotes
    private LocalDateTime submittedAt;
}
