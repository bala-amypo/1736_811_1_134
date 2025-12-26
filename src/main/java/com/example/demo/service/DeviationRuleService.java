package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;
import java.util.Optional;

public interface DeviationRuleService {
    DeviationRule createRule(DeviationRule rule);
    List<DeviationRule> getRulesBySurgery(String surgeryType);
    List<DeviationRule> getAllRules();
    Optional<DeviationRule> getRuleByCode(String ruleCode);
    DeviationRule updateRule(Long id, DeviationRule rule);
    List<DeviationRule> getActiveRules();
}
