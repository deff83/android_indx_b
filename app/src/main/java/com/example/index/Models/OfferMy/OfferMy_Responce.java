package com.example.index.Models.OfferMy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OfferMy_Responce {
    private int code;
    private String desc;
    @SerializedName("value")
    private List<OfferMy> offerIdsList;

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

    public List<OfferMy> getOfferIdsList() {
        return offerIdsList;
    }

    public void setOfferIdsList(List<OfferMy> offerIdsList) {
        this.offerIdsList = offerIdsList;
    }

    @Override
    public String toString() {
        return "OfferList_Responce{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", offerIdsList=" + offerIdsList +
                '}';
    }
}
