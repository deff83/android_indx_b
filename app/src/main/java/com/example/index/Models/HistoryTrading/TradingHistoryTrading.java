package com.example.index.Models.HistoryTrading;

public class TradingHistoryTrading {
    private int ID;
    private String DateStart;
    private String DateEnd;


    public TradingHistoryTrading(int ID, String dateStart, String dateEnd) {
        this.ID = ID;
        DateStart = dateStart;
        DateEnd = dateEnd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String dateStart) {
        DateStart = dateStart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String dateEnd) {
        DateEnd = dateEnd;
    }
}
