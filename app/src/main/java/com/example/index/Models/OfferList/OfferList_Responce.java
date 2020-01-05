package com.example.index.Models.OfferList;

import com.example.index.Models.Enums.IsBid;
import com.example.index.Models.Enums.KindTick;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class OfferList_Responce {
    private int idCoin = 60;
    private String name = "Download...";
    private int code;
    private String desc;
    @SerializedName("value")
    private List<OfferIds> offerIdsList = new ArrayList<>();

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

    public List<OfferIds> getOfferIdsList() {
        return offerIdsList;
    }

    public void setOfferIdsList(List<OfferIds> offerIdsList) {
        this.offerIdsList = offerIdsList;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public void setIdCoin(int idCoin) {
        this.idCoin = idCoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OfferIds> get_offerIdsList(IsBid isBid, int col){
        List<OfferIds> offerIdsList_isbid = new ArrayList<>();
        for (int i = 0; i < offerIdsList.size(); i++) {
            OfferIds offerIds = offerIdsList.get(i);
            if ((offerIds.getKind()==1) == isBid.isBid()){
                offerIdsList_isbid.add(offerIds);
            }
            if (offerIdsList_isbid.size()>=col) return offerIdsList_isbid;

        }
        return offerIdsList_isbid;
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
