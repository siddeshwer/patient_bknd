package com.locdoc.patient_bknd.controllers;

import com.locdoc.patient_bknd.models.AppointmentModel;
import com.locdoc.patient_bknd.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment/{id}")
    public List<AppointmentModel> getAppointmentById(@PathVariable("id") String id){
        return appointmentService.getAppointmentByPhone(id);
    }


    @PostMapping("/appointment/add")
    public String addAppointment(@RequestBody AppointmentModel appointmentModel)
    {
        appointmentService.addAppointment(appointmentModel);
        return "Appointment created ";
    }

    @GetMapping("/appointment/details/{email}")
    public List<AppointmentModel> getAppointmentByEmail(@PathVariable("email") String email)
    {
        return appointmentService.getAppointmentByMail(email);
    }

    @PutMapping("/appointment/update")
    public AppointmentModel updateAppointment(@RequestBody AppointmentModel appointmentModel)
    {
        appointmentService.updateAppointment(appointmentModel);
        return appointmentModel;
    }
}
