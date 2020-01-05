package com.example.index.Models.balance.MyCoin;

import com.example.index.Models.balance.Balance;

import java.util.List;

public class InfoUser {
    private String wmid;
    private String nickname;
    private Balance balance;
    private List<MyCoin> portfolio;
    private List<Profit> profit;

    public String getWmid() {
        return wmid;
    }

    public void setWmid(String wmid) {
        this.wmid = wmid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<MyCoin> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<MyCoin> portfolio) {
        this.portfolio = portfolio;
    }

    public List<Profit> getProfit() {
        return profit;
    }

    public void setProfit(List<Profit> profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "InfoUser{" +
                "wmid='" + wmid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", balance=" + balance +
                ", portfolio=" + portfolio +
                ", profit=" + profit +
                '}';
    }
}
