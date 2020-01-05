package com.example.index.Models.HistoryTrading;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyHistoryTrading {
    @SerializedName("ApiContext")
    private ApiContext apiContext;
    @SerializedName("Trading")
    private TradingHistoryTrading trading;

    public BodyHistoryTrading(ApiContext apiContext, TradingHistoryTrading trading) {
        this.apiContext = apiContext;
        this.trading = trading;
        String sign = new Shifr.Builder().set_zCoin(trading.getID()).set_DateEnd(trading.getDateEnd()).set_DateStart(trading.getDateStart()).build().base64_shifr(EnumIndex.HISTORYTRADING);
        apiContext.setSignature(sign);
    }
}
