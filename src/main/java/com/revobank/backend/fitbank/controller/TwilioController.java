package com.revobank.backend.fitbank.controller;

import com.revobank.backend.fitbank.model.response.ResponseModel;
import com.revobank.backend.fitbank.service.TwilioCallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/revobank/api")
@RestController
public class TwilioController {

    @Autowired
    TwilioCallerService twilioCallerService;


    @PostMapping("/twilio/send-sms")
    public ResponseModel createAccount(@RequestParam long pass, @RequestParam String phone, @RequestParam String idCaller){
        return twilioCallerService.sendSms(pass, phone ,idCaller);
    }


}
