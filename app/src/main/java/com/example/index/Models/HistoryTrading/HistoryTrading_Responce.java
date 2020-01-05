package com.example.index.Models.HistoryTrading;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryTrading_Responce {
    private int code;
    private String desc;
    @SerializedName("value")
    private List<HistoryTrading> historyTradingList;

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

    public List<HistoryTrading> getHistoryTradingList() {
        return historyTradingList;
    }

    public void setHistoryTradingList(List<HistoryTrading> historyTradingList) {
        this.historyTradingList = historyTradingList;
    }

    @Override
    public String toString() {
        return "HistoryTrading_Responce{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", historyTradingList=" + historyTradingList +
                '}';
    }
}
