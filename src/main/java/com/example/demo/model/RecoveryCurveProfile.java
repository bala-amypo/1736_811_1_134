package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecoveryCurveProfile {
    private Long id;
    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;
}
