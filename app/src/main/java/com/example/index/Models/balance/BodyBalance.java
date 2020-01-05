package com.example.index.Models.balance;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyBalance {
    @SerializedName("ApiContext")
    private ApiContext apiContext;

    public BodyBalance(ApiContext apiContext) {
        this.apiContext = apiContext;
        String sign = new Shifr.Builder().build().base64_shifr(EnumIndex.BALANCE);
        apiContext.setSignature(sign);
    }
}
