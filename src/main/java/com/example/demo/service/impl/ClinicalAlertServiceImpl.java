package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository repo;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository repo) {
        this.repo = repo;
    }

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        return repo.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAlertsByPatient(Long patientid) {
        return repo.findByPatient_Id(patientid);
    }

    @Override
    public ClinicalAlert resolveAlert(Long alertid) {
        ClinicalAlert alert = repo.findById(alertid)
                .orElseThrow(() -> new ResourceNotFoundException("Alert not found"));
        alert.setResolved(true);
        return repo.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return repo.findAll();
    }
}
