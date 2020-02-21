package com.revobank.backend.fitbank.model.db;

import javax.persistence.*;
import java.sql.Clob;
import java.util.Date;


@Entity
@Table(name = "log_audit_model")
public class LogAuditModel {

    @Id
    @SequenceGenerator(name="log_seq", sequenceName="log_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="log_seq")
    private long id;
    private String system;
    private long statusCode;
    private String step;
    @Lob
    private Clob payload;
    private String caller;
    private Date dateTime;
    private String action;

    public String getAction() {
        return action;
    }

    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LogAuditModel() {
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Clob getPayload() {
        return payload;
    }

    public void setPayload(Clob payload) {
        this.payload = payload;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }
}
