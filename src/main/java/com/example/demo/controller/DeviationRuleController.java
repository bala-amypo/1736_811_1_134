package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/deviation-rules")
@Tag(name = "Deviation Rules")
public class DeviationRuleController {

    private final DeviationRuleService deviationRuleService;

    public DeviationRuleController(DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }

    @PostMapping
    public ResponseEntity<DeviationRule> createRule(@RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.createRule(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviationRule> updateRule(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.updateRule(id, rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviationRule> getRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(deviationRuleService.getRuleById(id));
    }

    @GetMapping("/surgery/{surgeryType}")
    public ResponseEntity<List<DeviationRule>> getRulesBySurgery(
            @PathVariable String surgeryType) {
        return ResponseEntity.ok(deviationRuleService.getRulesBySurgery(surgeryType));
    }

    @GetMapping("/active")
    public ResponseEntity<List<DeviationRule>> getActiveRules() {
        return ResponseEntity.ok(deviationRuleService.getActiveRules());
    }

    @GetMapping
    public ResponseEntity<List<DeviationRule>> getAllRules() {
        return ResponseEntity.ok(deviationRuleService.getAllRules());
    }
}
