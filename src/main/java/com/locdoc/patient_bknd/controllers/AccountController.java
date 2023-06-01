package com.locdoc.patient_bknd.controllers;

import com.locdoc.patient_bknd.models.AccountModel;
import com.locdoc.patient_bknd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    //To get the account details by the given Id
    @GetMapping("/account/{email}")
    public AccountModel getAccountById(@PathVariable("email") String email){
        return accountService.getAccountByEmail(email);
    }


    @DeleteMapping("/account/delete/{id}")
    public String deleteAccountById(@PathVariable("id") String id){ accountService.deleteAccountById(id); return "Account Deleted with Id  " + id;}

    @PostMapping("/account/add")
    public String addAccount(@RequestBody AccountModel accountModel){
        accountService.addAccount(accountModel);
        return "Account Created with ID " + accountModel.getPhone();}

    @PutMapping("/account/update")
    public AccountModel updateAccount(@RequestBody AccountModel accountModel){
        accountService.updateAccount(accountModel); return accountModel;}
}
