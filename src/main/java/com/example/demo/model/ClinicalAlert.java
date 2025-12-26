package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClinicalAlert {
    private Long id;
    private Long patientId;
    private Long logId;
    private String alertType;
    private String severity;
    private String message;
    @Builder.Default
    private Boolean resolved = false; // default false
}
