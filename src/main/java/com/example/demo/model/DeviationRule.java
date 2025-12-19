package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deviation_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String surgeryType;

    @NotBlank
    @Column(nullable = false)
    private String parameter;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer threshold;

    @NotBlank
    @Column(nullable = false)
    private String severity;

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;
}
