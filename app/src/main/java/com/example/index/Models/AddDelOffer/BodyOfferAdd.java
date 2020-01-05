package com.example.index.Models.AddDelOffer;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyOfferAdd {
    @SerializedName("ApiContext")
    private ApiContext apiContext;
    @SerializedName("Offer")
    private AddOffer addOffer;

    public BodyOfferAdd(ApiContext apiContext, AddOffer addOffer) {
        this.apiContext = apiContext;
        this.addOffer = addOffer;
        String sign = new Shifr.Builder().set_zCoin(addOffer.getID()).build().base64_shifr(EnumIndex.OFFERADD);
        apiContext.setSignature(sign);
    }
}
