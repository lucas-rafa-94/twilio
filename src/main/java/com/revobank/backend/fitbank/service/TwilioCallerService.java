package com.revobank.backend.fitbank.service;

import com.google.gson.Gson;

import com.revobank.backend.fitbank.model.CreateAccountModel;
import com.revobank.backend.fitbank.model.response.ResponseModel;
import com.revobank.backend.fitbank.utils.Helper;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwilioCallerService {

    final String uri = "https://sandboxapi.fitbank.com.br/main/execute";

    @Autowired
    Helper helper;

    public static final String ACCOUNT_SID =
            "AC81d375f3b4579c0da6814f608a964799";
    public static final String AUTH_TOKEN =
            "7a5246a087ded3efcf1d9a4797fb03de";

    public ResponseModel sendSms(long pass, String number, String idCaller ) {
        ResponseModel responseModel = new ResponseModel();

        long response = 0;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        helper.createLog("TWILIO", "REQUEST","Revobank senha de confirmação: ".concat(" " + pass + " from " + number)  , idCaller, "SEND_SMS", 0);
        System.out.println(pass);

        String str = "Revobank senha " + String.valueOf(pass);
        System.out.println(str);
        try {
            Message message = Message.creator(new PhoneNumber("+55" + number), // to
                    new PhoneNumber("+12058283216"), // from
                    str)
                    .create();
            responseModel.setStatus(200);
            responseModel.setMessage("Sms enviado com sucesso!");
            response = helper.createLog("TWILIO", "RESPONSE","Revobank senha de confirmação: ".concat(" " + pass + " from " + number)  , idCaller, "SEND_SMS", 200);
        }catch (Exception e){
            e.printStackTrace();
            responseModel.setStatus(500);
            responseModel.setMessage("Erro ao enviar SMS!");
            helper.createErrorLog(response, e.getMessage());
        }

        return responseModel;

    }


}
