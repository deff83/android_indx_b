package com.example.index;

public class Params {
    private boolean isOfferList = true;
    private boolean isMyOrders = true;
    private boolean isToolBar = true;
    private boolean isBalance = true;
    private boolean isHistoryTrading = true;
    private boolean isHistoryTransaction = true;
    private boolean isTick = true;
    private boolean isOfferAdd = true;
    private boolean isOfferDelete = true;

    private int col = 20;


    public boolean isOfferList() {
        return isOfferList;
    }

    public void setOfferList(boolean offerList) {
        isOfferList = offerList;
    }

    public boolean isMyOrders() {
        return isMyOrders;
    }

    public void setMyOrders(boolean myOrders) {
        isMyOrders = myOrders;
    }

    public boolean isToolBar() {
        return isToolBar;
    }

    public void setToolBar(boolean toolBar) {
        isToolBar = toolBar;
    }

    public boolean isBalance() {
        return isBalance;
    }

    public void setBalance(boolean balance) {
        isBalance = balance;
    }

    public boolean isHistoryTrading() {
        return isHistoryTrading;
    }

    public void setHistoryTrading(boolean historyTrading) {
        isHistoryTrading = historyTrading;
    }

    public boolean isHistoryTransaction() {
        return isHistoryTransaction;
    }

    public void setHistoryTransaction(boolean historyTransaction) {
        isHistoryTransaction = historyTransaction;
    }

    public boolean isTick() {
        return isTick;
    }

    public void setTick(boolean tick) {
        isTick = tick;
    }

    public boolean isOfferAdd() {
        return isOfferAdd;
    }

    public void setOfferAdd(boolean offerAdd) {
        isOfferAdd = offerAdd;
    }

    public boolean isOfferDelete() {
        return isOfferDelete;
    }

    public void setOfferDelete(boolean offerDelete) {
        isOfferDelete = offerDelete;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
