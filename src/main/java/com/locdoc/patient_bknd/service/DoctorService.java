package com.locdoc.patient_bknd.service;

import com.locdoc.patient_bknd.models.AccountModel;
import com.locdoc.patient_bknd.models.DoctorModel;
import com.locdoc.patient_bknd.repository.DoctorRepository;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public MongoTemplate mongoTemplate;

    public DoctorModel getDoctorById(String id)
    {
        return doctorRepository.findById(id).isPresent() ? doctorRepository.findById(id).get() : null;
    }

    public DoctorModel getDoctorByEmail(String email)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        DoctorModel doctorDetails = mongoTemplate.findOne(query, DoctorModel.class);
        return doctorDetails;
    }

    public List<DoctorModel> getDoctorBySpeciality(String speciality){
        Query query = new Query();
        query.addCriteria(Criteria.where("speciality").is(speciality));
        List<DoctorModel> specialityDoctorList = mongoTemplate.find(query, DoctorModel.class);
        return specialityDoctorList ;
    }

    public List<DoctorModel> getDoctorList()
    {
        return doctorRepository.findAll();
    }

    public BsonValue addDoctor(DoctorModel doctorModel){
        Query query = new Query().addCriteria(Criteria.where("_id").is(doctorModel.getPhone()));
        UpdateDefinition updateDefinition = new Update()
                .set("name",doctorModel.getName())
                .set("email",doctorModel.getEmail())
                .set("phone",doctorModel.getPhone())
                .set("degree",doctorModel.getDegree())
                .set("address",doctorModel.getAddress())
                .set("speciality",doctorModel.getSpeciality());

        UpdateResult updateResult = mongoTemplate.upsert(query, updateDefinition, DoctorModel.class);
        return updateResult.getUpsertedId();
    }

    public void updateDoctor(DoctorModel doctorModel){
        doctorRepository.save(doctorModel);
    }

}
