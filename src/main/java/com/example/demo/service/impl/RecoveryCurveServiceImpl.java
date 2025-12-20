package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.service.RecoveryCurveService;

import java.util.List;

@Service
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    @Autowired
    RecoveryCurveProfileRepository repo;

    @Override
    public RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile entry) {
        return repo.save(entry);
    }

    @Override
    public List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType) {
        return repo.findBySurgeryType(surgeryType);
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {
        return repo.findAll();
    }
}
