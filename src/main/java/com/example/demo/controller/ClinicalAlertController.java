package com.example.demo.controller;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Clinical Alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ClinicalAlert triggerAlert(@RequestBody ClinicalAlert alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public ClinicalAlert resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/patient/{patientid}")
    public List<ClinicalAlert> getAlertsByPatient(@PathVariable Long patientid) {
        return service.getAlertsByPatient(patientid);
    }

    @GetMapping("/{id}")
    public ClinicalAlert getAlertById(@PathVariable Long id) {
        return service.getAlertById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }

    @GetMapping
    public List<ClinicalAlert> getAllAlerts() {
        return service.getAllAlerts();
    }
}
