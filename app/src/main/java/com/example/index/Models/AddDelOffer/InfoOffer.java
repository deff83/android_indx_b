package com.example.index.Models.AddDelOffer;

public class InfoOffer {
    private int Code;
    private int OfferID;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public int getOfferID() {
        return OfferID;
    }

    public void setOfferID(int offerID) {
        OfferID = offerID;
    }

    @Override
    public String toString() {
        return "InfoOffer{" +
                "Code=" + Code +
                ", OfferID=" + OfferID +
                '}';
    }
}
