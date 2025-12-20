package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public PatientProfile createPatient(@Valid @RequestBody PatientProfile patient) {
        return service.createPatient(patient);
    }

    @GetMapping("/get/{id}")
    public PatientProfile getPatient(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @GetMapping("/get")
    public List<PatientProfile> getAllPatients() {
        return service.getAllPatients();
    }

    @PutMapping("/status/{id}")
    public String updateStatus(@PathVariable Long id) {
        service.updatePatientStatus(id, true);
        return "Status Updated";
    }
}
