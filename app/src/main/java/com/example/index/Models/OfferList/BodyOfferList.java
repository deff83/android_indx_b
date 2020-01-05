package com.example.index.Models.OfferList;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.example.index.Models.HistoryTrading.Trading;
import com.google.gson.annotations.SerializedName;

public class BodyOfferList {
    @SerializedName("ApiContext")
    private ApiContext apiContext;
    @SerializedName("Trading")
    private Trading trading;

    public BodyOfferList(ApiContext apiContext, Trading trading) {
        this.apiContext = apiContext;
        this.trading = trading;
        String sign = new Shifr.Builder().set_zCoin(trading.getID()).build().base64_shifr(EnumIndex.OFFERLIST);
        apiContext.setSignature(sign);
    }
}
