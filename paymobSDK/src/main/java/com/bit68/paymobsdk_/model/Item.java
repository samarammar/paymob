package com.bit68.paymobsdk_.model;

public class Item {

    private String name;

    private String amount;

    private String description;

    private String quantity;

    public Item(String name, String amount, String description, String quantity) {
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
