package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PatientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String patientId;
    private String fullName;
    private Integer age;
    @Column(unique=true)
    private String email;
    private String surgeryType;
    private boolean active;
    private LocalDateTime createdAt;
    public PatientProfile(Long id, String patientId, String fullName, Integer age, String email, String surgeryType,
            boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.surgeryType = surgeryType;
        this.active = active;
        this.createdAt = createdAt;
    }
    public PatientProfile() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSurgeryType() {
        return surgeryType;
    }
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
    

}
