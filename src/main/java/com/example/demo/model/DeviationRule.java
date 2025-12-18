package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviationRule{

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String surgeryType;
    private String symptomParameter;
    private Integer thresholdDeviation;
    private boolean active;

    public DeviationRule(Long id,String surgeryType,String symptomParameter,Integer thresholdDeviation,boolean ac){
        //this.id=id;
        this.name=name;
        this.email=email;
        this.cgpa=cgpa;
    }
    public StudentEntity(){

    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setCgpa(){
        this.cgpa=cgpa;
    }
    public float getcgpa(){
        return this.cgpa;   
    }
}
