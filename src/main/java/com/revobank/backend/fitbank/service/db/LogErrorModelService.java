package com.revobank.backend.fitbank.service.db;

import com.revobank.backend.fitbank.model.db.LogErrorModel;
import com.revobank.backend.fitbank.repository.LogErrorModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogErrorModelService {
    @Autowired
    LogErrorModelRepository logErrorModelRepository;

    public void save(LogErrorModel logErrorModel){
        logErrorModelRepository.save(logErrorModel);
    }
}
