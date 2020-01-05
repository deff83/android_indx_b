package com.example.index.Models.Enums;

public enum KindTick {
    DAY(1),
    WEEK(2),
    MONTH(3),
    YEAR(4);

    int kind;

    KindTick(int kind) {
        this.kind = kind;
    }

    public int getKind() {
        return kind;
    }
}
