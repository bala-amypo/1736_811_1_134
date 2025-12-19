package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DeviationRule;

public interface DeviationRuleRepository extends JpaRepository<DeviationRule, Long> {

    List<DeviationRule> findBySurgeryType(String surgeryType);

    List<DeviationRule> findByActiveTrue();
}
