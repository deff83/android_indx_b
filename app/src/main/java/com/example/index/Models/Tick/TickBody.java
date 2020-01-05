package com.example.index.Models.Tick;

public class TickBody {
    private int ID;
    private int Kind;

    public TickBody(int ID, int kind) {
        this.ID = ID;
        Kind = kind;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getKind() {
        return Kind;
    }

    public void setKind(int kind) {
        Kind = kind;
    }
}
