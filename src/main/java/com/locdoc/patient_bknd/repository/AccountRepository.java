package com.locdoc.patient_bknd.repository;

import com.locdoc.patient_bknd.models.AccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountModel, String> {
}
