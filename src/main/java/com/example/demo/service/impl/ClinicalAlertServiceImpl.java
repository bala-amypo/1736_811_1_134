package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    @Autowired
    ClinicalAlertRepository repo;

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        alert.setResolved(false);
        return repo.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAlertsByPatient(Long patientid) {
        return repo.findByPatientid(patientid);
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
