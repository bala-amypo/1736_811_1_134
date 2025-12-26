package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;

import java.util.List;
import java.util.Optional;

public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAlertsByPatient(Long patientId) {
        return repository.findByPatientid(patientId);
    }

    @Override
    public Optional<ClinicalAlert> getAlertById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ClinicalAlert resolveAlert(Long id) {
        ClinicalAlert alert = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return repository.findAll();
    }
}
