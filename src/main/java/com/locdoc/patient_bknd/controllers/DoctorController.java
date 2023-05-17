package com.locdoc.patient_bknd.controllers;

import com.locdoc.patient_bknd.models.DoctorModel;
import com.locdoc.patient_bknd.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor/{id}")
    public DoctorModel getDoctorById(@PathVariable("id") String id)
    {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/doctor/details/{email}")
    public DoctorModel getDoctorByEmail(@PathVariable("email") String email)
    {
        return doctorService.getDoctorByEmail(email);
    }

    @GetMapping("/doctor")
    public List<DoctorModel> getDoctor()
    {
        return doctorService.getDoctorList();
    }

    @GetMapping("/doctor/list/{speciality}")
    public List<DoctorModel> getDoctorBySpeciality(@PathVariable("speciality") String speciality){
        return doctorService.getDoctorBySpeciality(speciality);
    }

    @PostMapping("/doctor/add")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorModel doctorModel)
    {
        doctorService.addDoctor(doctorModel);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Methods","POST, GET, OPTIONS, PUT, DElETE");
        responseHeaders.set("Access-Control-Allow-Headers","Content-Type, X-Auth-Token, Origin, Authorization");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body("Doctor Details Updated");
    }

    @PutMapping("/doctor/update")
    public String updateDoctor(@RequestBody DoctorModel doctorModel)
    {
        doctorService.updateDoctor(doctorModel);
        return "Doctor Details Updated";
    }
}
