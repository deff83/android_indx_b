package com.example.index.Models.Tools;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyTools {
    @SerializedName("ApiContext")
    private ApiContext apiContext;

    public BodyTools(ApiContext apiContext) {
        this.apiContext = apiContext;
        String sign = new Shifr.Builder().build().base64_shifr(EnumIndex.TOOLS);
        apiContext.setSignature(sign);
    }
}
