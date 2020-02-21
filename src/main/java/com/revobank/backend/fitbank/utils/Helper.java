package com.revobank.backend.fitbank.utils;

import com.revobank.backend.fitbank.model.db.LogAuditModel;
import com.revobank.backend.fitbank.model.db.LogErrorModel;
import com.revobank.backend.fitbank.service.db.LogAuditModelService;
import com.revobank.backend.fitbank.service.db.LogErrorModelService;
import org.hibernate.engine.jdbc.ClobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Service
public class Helper {

    @Autowired
    LogAuditModelService logAuditModelService;

    @Autowired
    LogErrorModelService logErrorModelService;


    public long createLog(String system, String step, String payload, String caller, String action, long status){
        long id = 0;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00"));
        Date dateNow = calendar.getTime();

        LogAuditModel logAuditModel = new LogAuditModel();

        logAuditModel.setStatusCode(status);
        logAuditModel.setAction(action);
        logAuditModel.setPayload(ClobProxy.generateProxy(payload));
        logAuditModel.setStep(step);
        logAuditModel.setSystem(system);
        logAuditModel.setDateTime(dateNow);

        if(!caller.equals("") || caller != null){
            logAuditModel.setCaller(caller);
        }else {
            logAuditModel.setCaller("none");
        }

        id = logAuditModelService.saveLog(logAuditModel).getId();

        return id;
    }

    @Async
    public void createErrorLog(long id, String message){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00"));
        Date dateNow = calendar.getTime();

        LogErrorModel logErrorModel = new LogErrorModel();

       logErrorModel.setId(id);
       logErrorModel.setMessage(message);
       logErrorModel.setDateTime(dateNow);

       logErrorModelService.save(logErrorModel);
    }



}
