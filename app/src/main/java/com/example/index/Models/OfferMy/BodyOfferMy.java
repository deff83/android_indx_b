package com.example.index.Models.OfferMy;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyOfferMy {
    @SerializedName("ApiContext")
    private ApiContext apiContext;

    public BodyOfferMy(ApiContext apiContext) {
        this.apiContext = apiContext;

        String sign = new Shifr.Builder().build().base64_shifr(EnumIndex.OFFERMY);
        apiContext.setSignature(sign);
    }
}
