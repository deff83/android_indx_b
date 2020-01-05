package com.example.index.Models.AddDelOffer;

public class AddOffer {
    private int ID;
    private int Count;
    private boolean IsAnonymous;
    private boolean IsBid;
    private double Price;

    public AddOffer(int ID, int count, boolean isAnonymous, boolean isBid, double price) {
        this.ID = ID;
        Count = count;
        IsAnonymous = isAnonymous;
        IsBid = isBid;
        Price = price;
    }

    public int getID() {
        return ID;
    }

    public int getCount() {
        return Count;
    }

    public boolean isAnonymous() {
        return IsAnonymous;
    }

    public boolean isBid() {
        return IsBid;
    }

    public double getPrice() {
        return Price;
    }
}
