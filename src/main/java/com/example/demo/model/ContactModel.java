package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.entity.Contact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ContactModel extends OperationModel {
    private Long id;
    public Long getId(){
        return id;
    }
    public void setId(Long value){
        this.id = value;
    }
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String value){
        this.name = value;
    }
    private Date dob;
    public Date getDob(){
        return dob;
    }
    public void setDob(Date value){
        this.dob = value;
    }
    private int age;

    public int getAge(){
        return age;
    }
    public void setAge(int value){
        this.age = value;
    }
    private String email;
    public String getEmail(){
        return email;
    }
    public void setEmail(String value){
        this.email = value;
    }
    public void fromEntity(Contact contact){
        this.id = contact.getId();
        this.name = contact.getName();
        this.age = contact.getAge();
        this.dob = contact.getDob();
        this.email = contact.getEmail();
    }
}


