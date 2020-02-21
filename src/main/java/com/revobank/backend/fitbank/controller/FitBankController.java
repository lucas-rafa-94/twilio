package com.revobank.backend.fitbank.controller;

import com.revobank.backend.fitbank.model.CreateAccountModel;
import com.revobank.backend.fitbank.model.response.ResponseModel;
import com.revobank.backend.fitbank.service.FitBankCallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/revobank/api")
@RestController
public class FitBankController {

    @Autowired
    FitBankCallerService fitBankCallerService;


    @PostMapping("/fitbank/account")
    public ResponseModel createAccount(@RequestBody CreateAccountModel createAccountModel, @RequestParam String idCaller){
        return fitBankCallerService.createAccount(createAccountModel, idCaller);
    }


}
