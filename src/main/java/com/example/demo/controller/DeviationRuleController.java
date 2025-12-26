package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
@Tag(name = "Deviation Rules")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public DeviationRule updateRule(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<DeviationRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/{id}")
    public DeviationRule getById(@PathVariable Long id) {
        return service.getRuleByCode(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @GetMapping
    public List<DeviationRule> getAllRules() {
        return service.getAllRules();
    }
}
