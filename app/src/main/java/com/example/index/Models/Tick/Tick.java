package com.example.index.Models.Tick;

public class Tick {
    private long t;
    private double min;
    private double max;
    private double open;
    private double close;
    private double avg;
    private int total;

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Tick{" +
                "t=" + t +
                ", min=" + min +
                ", max=" + max +
                ", open=" + open +
                ", close=" + close +
                ", avg=" + avg +
                ", total=" + total +
                '}';
    }
}
