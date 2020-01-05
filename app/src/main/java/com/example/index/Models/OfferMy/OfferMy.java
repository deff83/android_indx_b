package com.example.index.Models.OfferMy;

public class OfferMy {
    private int toolid;
    private int offerid;
    private String name;
    private int kind;
    private double price;
    private int notes;
    private long stamp;

    public int getToolid() {
        return toolid;
    }

    public void setToolid(int toolid) {
        this.toolid = toolid;
    }

    public int getOfferid() {
        return offerid;
    }

    public void setOfferid(int offerid) {
        this.offerid = offerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    @Override
    public String toString() {
        return "OfferMy{" +
                "toolid=" + toolid +
                ", offerid=" + offerid +
                ", name='" + name + '\'' +
                ", kind=" + kind +
                ", price=" + price +
                ", notes=" + notes +
                ", stamp=" + stamp +
                '}';
    }
}
