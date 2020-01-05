package com.example.index.Models.HistoriTransaction;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.example.index.Models.HistoryTrading.TradingHistoryTrading;
import com.google.gson.annotations.SerializedName;

public class BodyHistoryTransaction {
    @SerializedName("ApiContext")
    private ApiContext apiContext;
    @SerializedName("Trading")
    private TradingHistoryTrading trading;

    public BodyHistoryTransaction(ApiContext apiContext, TradingHistoryTrading trading) {
        this.apiContext = apiContext;
        this.trading = trading;
        String sign = new Shifr.Builder().set_zCoin(trading.getID()).set_DateEnd(trading.getDateEnd()).set_DateStart(trading.getDateStart()).build().base64_shifr(EnumIndex.HISTORYTRANSACTION);
        apiContext.setSignature(sign);
    }
}
