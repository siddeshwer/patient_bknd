package com.locdoc.patient_bknd.models;

import jakarta.persistence.GenerationType;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;


@Document
public class AppointmentModel {
    @Id
    private String id;
    private String patient_phone;
    private String appointment_date;
    private String appointment_time;
    private String patient_name;
    private String patient_email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String appointment_doctor;



    public AppointmentModel(String id,String patient_phone, String appointment_date, String appointment_time, String patient_name, String patient_email, String appointment_doctor) {
        this.id = id;
        this.patient_phone = patient_phone;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.patient_name = patient_name;
        this.patient_email = patient_email;
        this.appointment_doctor = appointment_doctor;
    }

    public AppointmentModel() {

    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getAppointment_doctor() {
        return appointment_doctor;
    }

    public void setAppointment_doctor(String appointment_doctor) {
        this.appointment_doctor = appointment_doctor;
    }
}
