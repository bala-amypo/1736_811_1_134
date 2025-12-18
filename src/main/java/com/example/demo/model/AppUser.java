package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appuser{

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;

    public AppUser(Long id,String email,String password,String role){
        //this.id=id;
        this.email=email;
        this.password=password;
        this.role=role;
    }
    public AppUser(){

    }
    public void set(String name){
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
