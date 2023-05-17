package com.locdoc.patient_bknd.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class AccountModel {

    @Id
    private String phone;
    private String name;
    private String email;
    private String address;
    private String aadhar;
    private String birth_date;
    private String blood_group;


    public AccountModel(String phone, String name, String email, String address, String aadhar, String birth_date, String blood_group) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.address = address;
        this.aadhar = aadhar;
        this.birth_date = birth_date;
        this.blood_group = blood_group;
    }

    public AccountModel() {

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

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
}
