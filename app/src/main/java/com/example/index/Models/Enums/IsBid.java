package com.example.index.Models.Enums;

public enum IsBid {
    BUY(true),
    SELL(false);

    private boolean isBid;

    IsBid(boolean isBid) {
        this.isBid = isBid;
    }

    public boolean isBid() {
        return isBid;
    }
}
