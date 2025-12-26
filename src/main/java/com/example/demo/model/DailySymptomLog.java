package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private LocalDate logDate;

    private int painLevel;        // 0–10
    private int mobilityLevel;    // 0–10
    private int fatigueLevel;     // 0–10

    private String notes;         // symptoms / comments
}
