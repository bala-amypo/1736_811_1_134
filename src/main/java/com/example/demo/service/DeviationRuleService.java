package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;

public interface DeviationRuleService {

    List<DeviationRule> getActiveRules();

    DeviationRule createRule(DeviationRule rule);

    DeviationRule updateRule(Long id, DeviationRule rule);
}
