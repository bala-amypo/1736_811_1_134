package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient Profile")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PatientProfile createPatient(@RequestBody PatientProfile patient) {
        return service.createPatient(patient);
    }

    @GetMapping("/{id}")
    public PatientProfile getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @GetMapping
    public List<PatientProfile> getAllPatients() {
        return service.getAllPatients();
    }

    @PutMapping("/{id}/status")
    public PatientProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updatePatientStatus(id, active);
    }

    @GetMapping("/lookup/{patientid}")
    public PatientProfile lookupByPatientId(@PathVariable String patientid) {
        return service.findByPatientId(patientid)
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }
}
