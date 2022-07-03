package com.bit68.paymobsdk_.model;

public class WalletDataModel {
    private String public_key;

    private String client_secret;

    private String method;

    private String subtype;

    private String wallet_number;

    private FingerprintData fingerprint_data;

    public WalletDataModel(String public_key, String client_secret,
                           String method, String subtype, String wallet_number, FingerprintData fingerprint_data) {
        this.public_key = public_key;
        this.client_secret = client_secret;
        this.method = method;
        this.subtype = subtype;
        this.wallet_number = wallet_number;
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

    public String getWallet_number() {
        return wallet_number;
    }

    public void setWallet_number(String wallet_number) {
        this.wallet_number = wallet_number;
    }

    public FingerprintData getFingerprint_data() {
        return fingerprint_data;
    }

    public void setFingerprint_data(FingerprintData fingerprint_data) {
        this.fingerprint_data = fingerprint_data;
    }
}
