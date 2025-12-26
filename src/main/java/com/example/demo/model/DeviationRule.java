package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviationRule {
    private Long id;
    private String ruleCode; // test references this
    private String parameter;
    private Integer threshold;
    private String severity;
    @Builder.Default
    private Boolean active = true; // default true
}
