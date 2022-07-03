package com.bit68.paymobsdk_.model;

public class CardsModel {
    String cardName;
    int cardPhoto;

    public CardsModel(String cardName, int cardPhoto) {
        this.cardName = cardName;
        this.cardPhoto = cardPhoto;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(int cardPhoto) {
        this.cardPhoto = cardPhoto;
    }
}
