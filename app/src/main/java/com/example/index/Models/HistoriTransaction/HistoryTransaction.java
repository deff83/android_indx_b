package com.example.index.Models.HistoriTransaction;

public class HistoryTransaction {

    private long stamp;
    private int kind;
    private int amount;
    private int wmtranid;
    private String purse;
    private String desc;

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWmtranid() {
        return wmtranid;
    }

    public void setWmtranid(int wmtranid) {
        this.wmtranid = wmtranid;
    }

    public String getPurse() {
        return purse;
    }

    public void setPurse(String purse) {
        this.purse = purse;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "HistoryTransaction{" +
                "stamp=" + stamp +
                ", kind=" + kind +
                ", amount=" + amount +
                ", wmtranid=" + wmtranid +
                ", purse='" + purse + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
