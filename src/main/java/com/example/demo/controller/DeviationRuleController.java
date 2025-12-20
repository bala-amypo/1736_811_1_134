package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rule")
public class DeviationRuleController {

    private final DeviationRuleService service;

    public DeviationRuleController(DeviationRuleService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public DeviationRule createRule(@Valid @RequestBody DeviationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/get/{surgeryType}")
    public List<DeviationRule> getRules(@PathVariable String surgeryType) {
        return service.getRulesBySurgery(surgeryType);
    }

    @GetMapping("/get")
    public List<DeviationRule> getAllRules() {
        return service.getAllRules();
    }
}
