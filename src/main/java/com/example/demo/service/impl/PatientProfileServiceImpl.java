package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    @Autowired
    PatientProfileRepository repo;

    @Override
    public PatientProfile createPatient(PatientProfile patient) {
        if (repo.findByEmail(patient.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        return repo.save(patient);
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return repo.findAll();
    }

    @Override
    public void updatePatientStatus(Long id, boolean active) {
        PatientProfile patient = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        patient.setActive(active);
        repo.save(patient);
    }
}
