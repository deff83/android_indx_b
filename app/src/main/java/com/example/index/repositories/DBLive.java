package com.example.index.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.index.Models.AddDelOffer.OfferAdd_Responce;
import com.example.index.Models.AddDelOffer.OfferDelete_Responce;
import com.example.index.Models.HistoriTransaction.HistoryTransaction_Responce;
import com.example.index.Models.HistoryTrading.HistoryTrading_Responce;
import com.example.index.Models.OfferList.OfferList_Responce;
import com.example.index.Models.OfferMy.OfferMy_Responce;
import com.example.index.Models.Tick.Responce_tick;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.Models.balance.Balance_Responce;
import com.example.index.Params;

public class DBLive {

    private static DBLive dbLive = new DBLive();
    private Params params;

    public static DBLive getInstance() {return  dbLive;}

    MutableLiveData<OfferList_Responce> offerList_responceMutableLiveData;
    MutableLiveData<Balance_Responce> balance_responceMutableLiveData;
    MutableLiveData<HistoryTrading_Responce> historyTrading_responceMutableLiveData;
    MutableLiveData<HistoryTransaction_Responce> historyTransaction_responceMutableLiveData;
    MutableLiveData<OfferMy_Responce> offerMy_responceMutableLiveData;
    MutableLiveData<Responce_tick> responce_tickMutableLiveData;
    MutableLiveData<OfferAdd_Responce> offerAdd_responceMutableLiveData;
    MutableLiveData<OfferDelete_Responce> offerDelete_responceMutableLiveData;
    MutableLiveData<Tools_Responce> tools_responceMutableLiveData;


    public DBLive() {
        params = new Params();
        offerList_responceMutableLiveData = new MutableLiveData<>();
        balance_responceMutableLiveData = new MutableLiveData<>();
        historyTrading_responceMutableLiveData = new MutableLiveData<>();
        historyTransaction_responceMutableLiveData = new MutableLiveData<>();
        offerMy_responceMutableLiveData = new MutableLiveData<>();
        responce_tickMutableLiveData = new MutableLiveData<>();
        offerAdd_responceMutableLiveData = new MutableLiveData<>();
        offerDelete_responceMutableLiveData = new MutableLiveData<>();
        tools_responceMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<OfferList_Responce> getOfferList_responceMutableLiveData() {
        return offerList_responceMutableLiveData;
    }

    public void setOfferList_responceMutableLiveData(OfferList_Responce offerList) {
        offerList_responceMutableLiveData.postValue(offerList);
    }

    public LiveData<Balance_Responce> getBalance_responceMutableLiveData() {
        return balance_responceMutableLiveData;
    }

    public void setBalance_responceMutableLiveData(Balance_Responce balance) {
        balance_responceMutableLiveData.postValue(balance);
    }

    public LiveData<HistoryTrading_Responce> getHistoryTrading_responceMutableLiveData() {
        return historyTrading_responceMutableLiveData;
    }

    public void setHistoryTrading_responceMutableLiveData(HistoryTrading_Responce historyTrading) {
        historyTrading_responceMutableLiveData.postValue(historyTrading);
    }

    public LiveData<HistoryTransaction_Responce> getHistoryTransaction_responceMutableLiveData() {
        return historyTransaction_responceMutableLiveData;
    }

    public void setHistoryTransaction_responceMutableLiveData(HistoryTransaction_Responce historyTransaction) {
        historyTransaction_responceMutableLiveData.postValue(historyTransaction);
    }

    public LiveData<OfferMy_Responce> getOfferMy_responceMutableLiveData() {
        return offerMy_responceMutableLiveData;
    }

    public void setOfferMy_responceMutableLiveData(OfferMy_Responce offerMy) {
        offerMy_responceMutableLiveData.postValue(offerMy);
    }

    public LiveData<Responce_tick> getResponce_tickMutableLiveData() {
        return responce_tickMutableLiveData;
    }

    public void setResponce_tickMutableLiveData(Responce_tick tick) {
        responce_tickMutableLiveData.postValue(tick);
    }

    public LiveData<OfferAdd_Responce> getOfferAdd_responceMutableLiveData() {
        return offerAdd_responceMutableLiveData;
    }

    public void setOfferAdd_responceMutableLiveData(OfferAdd_Responce offerAdd) {
        offerAdd_responceMutableLiveData.postValue(offerAdd);
    }

    public LiveData<OfferDelete_Responce> getOfferDelete_responceMutableLiveData() {
        return offerDelete_responceMutableLiveData;
    }

    public void setOfferDelete_responceMutableLiveData(OfferDelete_Responce offerDelete) {
        offerDelete_responceMutableLiveData.postValue(offerDelete);
    }

    public LiveData<Tools_Responce> getTools_responceMutableLiveData() {
        return tools_responceMutableLiveData;
    }

    public void setTools_responceMutableLiveData(Tools_Responce tools) {
        tools_responceMutableLiveData.postValue(tools);
    }

    public Params getParams() {
        return params;
    }
}
