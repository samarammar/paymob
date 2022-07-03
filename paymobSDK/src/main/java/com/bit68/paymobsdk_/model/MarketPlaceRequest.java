package com.bit68.paymobsdk_.model;

import java.util.List;

public class MarketPlaceRequest {


    private int amount;

    private String currency;

    private List<String> payment_methods = null;

    private List<Item> items = null;

    private BillingData billing_data;

    public MarketPlaceRequest(int amount, String currency, List<String> payment_methods, List<Item> items, BillingData billing_data) {
        this.amount = amount;
        this.currency = currency;
        this.payment_methods = payment_methods;
        this.items = items;
        this.billing_data = billing_data;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(List<String> payment_methods) {
        this.payment_methods = payment_methods;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public BillingData getBilling_data() {
        return billing_data;
    }

    public void setBilling_data(BillingData billing_data) {
        this.billing_data = billing_data;
    }
}
