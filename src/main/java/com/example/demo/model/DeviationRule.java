package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Type of surgery this rule applies to
    private String surgeryType;

    // Clinical symptom this rule is monitoring
    private String symptomParameter;

    // Threshold deviation; must be positive
    @Positive(message = "Threshold must be positive")
    private Integer thresholdDeviation;

    // Whether this rule is currently active
    private Boolean active;
}
