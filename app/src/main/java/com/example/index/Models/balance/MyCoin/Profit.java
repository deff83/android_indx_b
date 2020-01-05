package com.example.index.Models.balance.MyCoin;

public class Profit {
    private int symbolid;
    private double buy;
    private double sell;

    public int getSymbolid() {
        return symbolid;
    }

    public void setSymbolid(int symbolid) {
        this.symbolid = symbolid;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "symbolid=" + symbolid +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
