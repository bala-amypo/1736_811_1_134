package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DeviationRule;

public interface DeviationRuleService {

    DeviationRule createRule(DeviationRule rule);

    DeviationRule updateRule(Long id, DeviationRule rule);

    DeviationRule getRuleById(Long id);

    List<DeviationRule> getRulesBySurgery(String surgeryType);

    List<DeviationRule> getAllRules();

    List<DeviationRule> getActiveRules();
}
