package com.example.index.Models.balance;

import com.example.index.Models.balance.MyCoin.InfoUser;
import com.google.gson.annotations.SerializedName;

public class Balance_Responce {
    private int code;
    private String desc;
    @SerializedName("value")
    private InfoUser offerIdsList;

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

    public InfoUser getOfferIdsList() {
        return offerIdsList;
    }

    public void setOfferIdsList(InfoUser offerIdsList) {
        this.offerIdsList = offerIdsList;
    }

    @Override
    public String toString() {
        return "Balance_Responce{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", offerIdsList=" + offerIdsList +
                '}';
    }
}
