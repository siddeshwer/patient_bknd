package com.locdoc.patient_bknd.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DoctorModel {

    @Id
    private String phone;
    private String name;
    private String email;
    private String address;
    private String speciality;
    private String image;
    private String degree;

    public DoctorModel(String phone, String name, String email, String address, String speciality, String image, String degree) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.address = address;
        this.speciality = speciality;
        this.image = image;
        this.degree = degree;
    }

    public DoctorModel() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}
