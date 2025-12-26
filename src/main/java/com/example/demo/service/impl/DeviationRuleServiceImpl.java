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
    public List<DeviationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findAll()
                .stream()
                .filter(rule -> Boolean.TRUE.equals(rule.getActive()))
                .collect(Collectors.toList());
    }

    @Override
    public DeviationRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DeviationRule saveRule(DeviationRule rule) {
        if (rule.getThresholdDeviation() == null || rule.getThresholdDeviation() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }
        return repository.save(rule);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
