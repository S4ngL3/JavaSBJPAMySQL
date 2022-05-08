package com.example.demo.entity;
import com.example.demo.model.ContactModel;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.Date;
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void fromModel(ContactModel model){
        this.name = model.getName();
        this.age = model.getAge();
        this.dob = model.getDob();
        this.email = model.getEmail();
    }
}
