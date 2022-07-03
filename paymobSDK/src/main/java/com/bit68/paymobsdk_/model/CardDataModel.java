package com.bit68.paymobsdk_.model;

public class CardDataModel {


    private String public_key;

    private String client_secret;

    private String method;

    private String subtype;

    private String identifier;

    private String sourceholder_name;

    private String expiry_month;

    private String expiry_year;

    private String cvn;

    private FingerprintData fingerprint_data;

    public CardDataModel(String public_key, String client_secret, String method, String subtype, String identifier,
                         String sourceholder_name, String expiry_month, String expiry_year, String cvn, FingerprintData fingerprint_data) {
        this.public_key = public_key;
        this.client_secret = client_secret;
        this.method = method;
        this.subtype = subtype;
        this.identifier = identifier;
        this.sourceholder_name = sourceholder_name;
        this.expiry_month = expiry_month;
        this.expiry_year = expiry_year;
        this.cvn = cvn;
        this.fingerprint_data = fingerprint_data;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getSourceholder_name() {
        return sourceholder_name;
    }

    public void setSourceholder_name(String sourceholder_name) {
        this.sourceholder_name = sourceholder_name;
    }

    public String getExpiry_month() {
        return expiry_month;
    }

    public void setExpiry_month(String expiry_month) {
        this.expiry_month = expiry_month;
    }

    public String getExpiry_year() {
        return expiry_year;
    }

    public void setExpiry_year(String expiry_year) {
        this.expiry_year = expiry_year;
    }

    public String getCvn() {
        return cvn;
    }

    public void setCvn(String cvn) {
        this.cvn = cvn;
    }

    public FingerprintData getFingerprint_data() {
        return fingerprint_data;
    }

    public void setFingerprint_data(FingerprintData fingerprint_data) {
        this.fingerprint_data = fingerprint_data;
    }
}
