package com.example.index.Models.balance;

public class Balance {
    private double price;
    private double wmz;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWmz() {
        return wmz;
    }

    public void setWmz(double wmz) {
        this.wmz = wmz;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "price=" + price +
                ", wmz=" + wmz +
                '}';
    }
}
