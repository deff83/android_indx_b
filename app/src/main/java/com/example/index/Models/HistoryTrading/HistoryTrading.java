package com.example.index.Models.HistoryTrading;

public class HistoryTrading {
    private int id;
    private long stamp;
    private String name;
    private int isbid;
    private int notes;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStamp() {
        return stamp;
    }

    public void setStamp(long stamp) {
        this.stamp = stamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsbid() {
        return isbid;
    }

    public void setIsbid(int isbid) {
        this.isbid = isbid;
    }

    public int getNotes() {
        return notes;
    }

    public void setNotes(int notes) {
        this.notes = notes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HistoryTrading{" +
                "id=" + id +
                ", stamp=" + stamp +
                ", name='" + name + '\'' +
                ", isbid=" + isbid +
                ", notes=" + notes +
                ", price=" + price +
                '}';
    }
}
