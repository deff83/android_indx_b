package com.example.index.Models.balance.MyCoin;

public class MyCoin {
    private int id;
    private String name;
    private int notes;
    private double price;
    private String type;
    private int kind;
    private int by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "MyCoin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes=" + notes +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", kind=" + kind +
                ", by=" + by +
                '}';
    }
}
