package com.example.index.Models.Tick;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.Shifr;
import com.google.gson.annotations.SerializedName;

public class BodyTick {
    @SerializedName("ApiContext")
    private ApiContext apiContext;
    @SerializedName("Tick")
    private TickBody tickBody;

    public BodyTick(ApiContext apiContext, TickBody tickBody) {
        this.apiContext = apiContext;
        this.tickBody = tickBody;
        String sign = new Shifr.Builder().set_TickID(tickBody.getID()).set_TickKind(tickBody.getKind()).build().base64_shifr(EnumIndex.TICK);
        apiContext.setSignature(sign);
    }
}
