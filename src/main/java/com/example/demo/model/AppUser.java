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
    public void setEmail(String email){
        this.email=email;
    }
    public String getemail(){
        return this.email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getpassword(){
        return this.password;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getrole(){
        return this.role;   
    }
}
