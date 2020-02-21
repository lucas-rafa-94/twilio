package com.revobank.backend.fitbank.service.db;

import com.revobank.backend.fitbank.model.db.LogAuditModel;
import com.revobank.backend.fitbank.repository.LogAuditModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAuditModelService {
    @Autowired
    LogAuditModelRepository logAuditModelRepository;

    public LogAuditModel saveLog(LogAuditModel logAuditModel){
        return logAuditModelRepository.save(logAuditModel);
    }
}
