package com.bit68.paymobsdk_.model;

public class BillingData {

    private String email;

    private String first_name;

    private String phone_number;

    private String last_name;

    public BillingData(String email, String first_name, String phone_number, String last_name) {
        this.email = email;
        this.first_name = first_name;
        this.phone_number = phone_number;
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
