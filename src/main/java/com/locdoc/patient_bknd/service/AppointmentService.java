package com.locdoc.patient_bknd.service;

import com.locdoc.patient_bknd.models.AccountModel;
import com.locdoc.patient_bknd.models.AppointmentModel;
import com.locdoc.patient_bknd.models.DoctorModel;
import com.locdoc.patient_bknd.repository.AccountRepository;
import com.locdoc.patient_bknd.repository.AppointmentRepository;
import com.locdoc.patient_bknd.repository.DoctorRepository;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
   @Autowired
   private DoctorService doctorService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public MongoTemplate mongoTemplate;

    public Optional<AppointmentModel> getAppointmentById(String id){

        return appointmentRepository.findById(id);
    }

    public List<AppointmentModel> getAppointmentByPhone(String email)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("patient_email").is(email));
        List<AppointmentModel> patient_appointments = mongoTemplate.find(query, AppointmentModel.class);
        return patient_appointments;
    }

    public List<AppointmentModel> getAppointmentByMail(String email)
    {
      DoctorModel doctorDetails = doctorService.getDoctorByEmail(email);
      Query query = new Query();
      query.addCriteria(Criteria.where("appointment_doctor").is(doctorDetails.getName()));
      List<AppointmentModel> appointmentDetails = mongoTemplate.find(query, AppointmentModel.class);
      return appointmentDetails;
    }

    public void addAppointment(AppointmentModel appointmentModel)
    {
       appointmentRepository.save(appointmentModel);
    }

    public void updateAppointment(AppointmentModel appointmentModel)
    {
        appointmentRepository.save(appointmentModel);
    }

    public void deleteAppointmentByEmail(String email)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("patient_email").is(email));
        mongoTemplate.remove(query,AppointmentModel.class);
    }
}
