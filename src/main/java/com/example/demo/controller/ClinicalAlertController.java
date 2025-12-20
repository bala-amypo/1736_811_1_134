package com.example.demo.controller;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.service.ClinicalAlertService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alert")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public ClinicalAlert createAlert(@Valid @RequestBody ClinicalAlert alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/resolve/{id}")
    public ClinicalAlert resolveAlert(@PathVariable Long id) {
        return service.resolveAlert(id);
    }

    @GetMapping("/patient/{id}")
    public List<ClinicalAlert> getAlerts(@PathVariable Long id) {
        return service.getAlertsByPatient(id);
    }

    @GetMapping("/get")
    public List<ClinicalAlert> getAllAlerts() {
        return service.getAllAlerts();
    }
}
