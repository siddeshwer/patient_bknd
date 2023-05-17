package com.locdoc.patient_bknd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PatientBkndApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientBkndApplication.class, args);
    }

}
