package com.locdoc.patient_bknd.service;

import com.locdoc.patient_bknd.models.AccountModel;
import com.locdoc.patient_bknd.models.DoctorModel;
import com.locdoc.patient_bknd.repository.AccountRepository;
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
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public MongoTemplate mongoTemplate;

    public AccountModel getAccountByEmail(String email)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        AccountModel accountModel = mongoTemplate.findOne(query, AccountModel.class);
        return accountModel ;
    }

    public BsonValue addAccount(AccountModel accountModel){
        Query query = new Query().addCriteria(Criteria.where("_id").is(accountModel.getPhone()));
        UpdateDefinition updateDefinition = new Update()
                .set("name",accountModel.getName())
                .set("email",accountModel.getEmail())
                .set("phone",accountModel.getPhone())
                .set("aadhar",accountModel.getAadhar())
                .set("address",accountModel.getAddress())
                .set("blood_group",accountModel.getBlood_group())
                .set("birth_date",accountModel.getBirth_date());

        UpdateResult updateResult = mongoTemplate.upsert(query, updateDefinition, AccountModel.class);
        return updateResult.getUpsertedId();
    }

    public void updateAccount(AccountModel accountModel){
        accountRepository.save(accountModel);}

    public void deleteAccountById(String id){accountRepository.deleteById(id);}

}
