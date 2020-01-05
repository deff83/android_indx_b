package com.example.index.Models.AddDelOffer;

import com.google.gson.annotations.SerializedName;

public class OfferAdd_Responce {
    private int code;
    private String desc;
    @SerializedName("value")
    private InfoOffer infoOffer;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public InfoOffer getOfferIdsList() {
        return infoOffer;
    }

    public void setOfferIdsList(InfoOffer offerIdsList) {
        this.infoOffer = offerIdsList;
    }

    @Override
    public String toString() {
        return "Balance_Responce{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", offerIdsList=" + infoOffer +
                '}';
    }
}
