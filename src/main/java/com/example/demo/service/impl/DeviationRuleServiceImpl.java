package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;

import java.util.List;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    @Autowired
    DeviationRuleRepository repo;

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        if (rule.getThresholdDeviation() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }
        return repo.save(rule);
    }

    @Override
    public List<DeviationRule> getRulesBySurgery(String surgeryType) {
        return repo.findBySurgeryType(surgeryType);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return repo.findAll();
    }
}
