package com.locdoc.patient_bknd.repository;

import com.locdoc.patient_bknd.models.DoctorModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<DoctorModel,String> {
}
