package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    @Autowired
    DailySymptomLogRepository repo;

    @Override
    public DailySymptomLog recordLog(DailySymptomLog log) {
        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future date");
        }
        return repo.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientid) {
        return repo.findByPatientid(patientid);
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}
