package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repo;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public DailySymptomLog recordLog(DailySymptomLog log) {
        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future date");
        }
        return repo.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientid) {
        return repo.findByPatient_Id(patientid);
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }

    @Override
    public List<DailySymptomLog> getAllLogs() {
        return repo.findAll();
    }
}
