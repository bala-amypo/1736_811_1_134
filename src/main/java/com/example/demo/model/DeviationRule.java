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

    public DeviationRule(Long id,String surgeryType,String symptomParameter,Integer thresholdDeviation,boolean active){

        //this.id=id;
        this.surgeryType=surgeryType;
        this.symptomParameter=symptomParameter;
        this.thresholdDeviation=thresholdDeviation;
        this.active=active;
        
    }
    public DeviationRule(){

    }
    public void setSurgeryType(String surgeryType){
        this.surgeryType=surgeryType;
    }
    public String getSurgeryType(){
        return this.SurgeryType;
    }
    public void setSymptomParameter(){
        this.symptomParameter=symptomParameter;
    }
    public String getSymptomParameter(){
        return this.symptomParameter;
    }
    public void setThresholdDeviation(){
        this.thresholdDeviation=thresholdDeviation;
    }
    public Integer getThresholdDeviation(){
        return this.thresholdDeviation;   
    }
    public void setActive(){
        this.active=active;
    }
    public boolean getActive(){
        return this.active=active;   
    }

}
