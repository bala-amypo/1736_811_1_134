package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;

import java.util.List;
import java.util.Optional;

public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        if (rule.getThresholdDeviation() == null || rule.getThresholdDeviation() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }
        return repository.save(rule);
    }

    @Override
    public List<DeviationRule> getRulesBySurgery(String surgeryType) {
        return repository.findBySurgeryType(surgeryType);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {
        return repository.findById(Long.valueOf(ruleCode));
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        DeviationRule existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        existing.setThresholdDeviation(rule.getThresholdDeviation());
        existing.setActive(rule.getActive());
        return repository.save(existing);
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(DeviationRule::getActive)
                .toList();
    }
}
