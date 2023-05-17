package com.locdoc.patient_bknd.repository;

import com.locdoc.patient_bknd.models.AppointmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<AppointmentModel,String> {

}
