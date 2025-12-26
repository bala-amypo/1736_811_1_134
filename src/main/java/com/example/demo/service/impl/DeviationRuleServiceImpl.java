package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(r -> Boolean.TRUE.equals(r.getActive()))
                .collect(Collectors.toList());
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        if (rule.getThresholdDeviation() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }
        return repository.save(rule);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {
        DeviationRule existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));

        existing.setSurgeryType(rule.getSurgeryType());
        existing.setSymptomParameter(rule.getSymptomParameter());
        existing.setThresholdDeviation(rule.getThresholdDeviation());
        existing.setActive(rule.getActive());

        return repository.save(existing);
    }
}
