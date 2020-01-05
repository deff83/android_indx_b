package com.example.index.Models.AddDelOffer;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyOfferDelete {
    @SerializedName("ApiContext")
    private ApiContext apiContext;

    private int OfferId;

    public BodyOfferDelete(ApiContext apiContext, int OfferId) {
        this.apiContext = apiContext;
        this.OfferId = OfferId;
        String sign = new Shifr.Builder().set_offerid(OfferId).build().base64_shifr(EnumIndex.OFFERDELETE);
        apiContext.setSignature(sign);
    }
}
