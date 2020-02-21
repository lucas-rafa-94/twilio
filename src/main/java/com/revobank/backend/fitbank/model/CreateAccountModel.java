package com.revobank.backend.fitbank.model;

public class CreateAccountModel {

    private String Method;
    private long PartnerId;
    private long BusinessUnitId;
    private String Mail;
    private String Nickname;
    private String Name;
    private String TaxNumber;
    private long Phone;

    public CreateAccountModel(String method, long partnerId, long businessUnitId, String mail, String nickname, String name, String taxNumber, long phone) {
        Method = method;
        PartnerId = partnerId;
        BusinessUnitId = businessUnitId;
        Mail = mail;
        Nickname = nickname;
        Name = name;
        TaxNumber = taxNumber;
        Phone = phone;
    }

    public CreateAccountModel() {
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public long getPartnerId() {
        return PartnerId;
    }

    public void setPartnerId(long partnerId) {
        PartnerId = partnerId;
    }

    public long getBusinessUnitId() {
        return BusinessUnitId;
    }

    public void setBusinessUnitId(long businessUnitId) {
        BusinessUnitId = businessUnitId;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        TaxNumber = taxNumber;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        Phone = phone;
    }
}
