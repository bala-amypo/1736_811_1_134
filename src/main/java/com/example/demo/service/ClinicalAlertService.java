package com.example.demo.service;

import com.example.demo.entity.ClinicalAlert;
import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlert createAlert(ClinicalAlert alert);

    List<ClinicalAlert> getAlertsByPatient(Long patientid);

    ClinicalAlert resolveAlert(Long alertid);

    List<ClinicalAlert> getAllAlerts();
}
