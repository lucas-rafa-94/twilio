package com.revobank.backend.fitbank.repository;

import com.revobank.backend.fitbank.model.db.LogAuditModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogAuditModelRepository extends CrudRepository<LogAuditModel, Long> {
}
