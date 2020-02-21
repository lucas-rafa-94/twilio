package com.revobank.backend.fitbank.service;

import com.google.gson.Gson;

import com.revobank.backend.fitbank.model.CreateAccountModel;
import com.revobank.backend.fitbank.model.response.ResponseModel;
import com.revobank.backend.fitbank.utils.Helper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FitBankCallerService {

    final String uri = "https://sandboxapi.fitbank.com.br/main/execute";

    @Autowired
    Helper helper;


    public ResponseModel createAccount(CreateAccountModel createAccountModel, String idCaller){
        ResponseModel responseModel = new ResponseModel();

        long response = 0;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = null;
        Gson gson = new Gson();
        String output = "";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("Authorization", "Basic ODQxODQwZjktNGEwZS00NjY2LWJmM2ItMmNmMzQxYTRiMzVhOjZkYjc5ODkzLTJjN2QtNGNlMS05NGY1LWZjNDVjYTIzMzdjZQ==");

        CreateAccountModel createAccountModel1 = new CreateAccountModel();

        createAccountModel1.setBusinessUnitId(322);
        createAccountModel1.setPartnerId(335);
        createAccountModel1.setMethod("CreateAccount");
        createAccountModel1.setTaxNumber("05648546548");
        createAccountModel1.setName(createAccountModel.getName());
        createAccountModel1.setMail(createAccountModel.getMail());
        createAccountModel1.setNickname(createAccountModel.getNickname());
        createAccountModel1.setPhone(createAccountModel.getPhone());

        HttpEntity<CreateAccountModel> request = new HttpEntity<>(createAccountModel1, headers);

        try{
            response = helper.createLog("FIBANK", "REQUEST", gson.toJson(createAccountModel1), idCaller, "CREATE_ACCOUNT", 0);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            output = restTemplate.postForObject(uri , request, String.class);
            jsonObject = new JSONObject(output);
            try {
                if (jsonObject.getString("Success").equals("true")) {
                    response = helper.createLog("FITBANK", "RESPONSE", output, idCaller, "CREATE_ACCOUNT", 200);
                    responseModel.setStatus(200);
                    responseModel.setMessage("Conta criada com sucesso");
                } else {
                    response = helper.createLog("FITBANK", "RESPONSE", output, idCaller, "CREATE_ACCOUNT", 400);
                    responseModel.setStatus(400);
                    responseModel.setMessage("Conta nao criada");
                }
            }catch (Exception e){
                responseModel.setStatus(500);
                responseModel.setMessage("Erro no request, favor olhar logs.. " + "idLog: " + response);
                helper.createErrorLog(response, e.getMessage());
            }

        }catch (Exception e){
            helper.createErrorLog(response, e.getMessage());
        }
        return responseModel;
    }

}
