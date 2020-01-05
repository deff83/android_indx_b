package com.example.index.Models.OfferList;

public class OfferIds {
    private int offerid;
    private int kind;
    private double price;
    private int notes;

    public int getOfferid() {
        return offerid;
    }

    public void setOfferid(int offerid) {
        this.offerid = offerid;
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

    @Override
    public String toString() {
        return "OfferIds{" +
                "offerid=" + offerid +
                ", kind=" + kind +
                ", price=" + price +
                ", notes=" + notes +
                '}';
    }
}
