package com.example.index.repositories;

import com.example.index.Models.balance.Balance_Responce;
import com.example.index.Models.balance.BodyBalance;
import com.example.index.Models.HistoryTrading.BodyHistoryTrading;
import com.example.index.Models.HistoriTransaction.BodyHistoryTransaction;
import com.example.index.Models.AddDelOffer.BodyOfferAdd;
import com.example.index.Models.AddDelOffer.BodyOfferDelete;
import com.example.index.Models.OfferList.BodyOfferList;
import com.example.index.Models.OfferMy.BodyOfferMy;
import com.example.index.Models.Tick.BodyTick;
import com.example.index.Models.Tools.BodyTools;
import com.example.index.Models.HistoryTrading.HistoryTrading_Responce;
import com.example.index.Models.HistoriTransaction.HistoryTransaction_Responce;
import com.example.index.Models.AddDelOffer.OfferAdd_Responce;
import com.example.index.Models.AddDelOffer.OfferDelete_Responce;
import com.example.index.Models.OfferList.OfferList_Responce;
import com.example.index.Models.OfferMy.OfferMy_Responce;
import com.example.index.Models.Tick.Responce_tick;
import com.example.index.Models.Tools.Tools_Responce;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ResatAPIClient {

    @POST("OfferList")
    Call<OfferList_Responce> getOfferList(@Body BodyOfferList body);

    @POST("Tools")
    Call<Tools_Responce> getTools(@Body BodyTools body);

    @POST("Balance")
    Call<Balance_Responce> getBalance(@Body BodyBalance body);

    @POST("HistoryTrading")
    Call<HistoryTrading_Responce> getHistoryTrading(@Body BodyHistoryTrading body);

    @POST("HistoryTransaction")
    Call<HistoryTransaction_Responce> getHistoryTransaction(@Body BodyHistoryTransaction body);

    @POST("OfferMy")
    Call<OfferMy_Responce> getOfferMy(@Body BodyOfferMy body);

    @POST("tick")
    Call<Responce_tick> getTick(@Body BodyTick body);

    @POST("OfferAdd")
    Call<OfferAdd_Responce> getOfferAdd(@Body BodyOfferAdd body);

    @POST("OfferDelete")
    Call<OfferDelete_Responce> getOfferDelete(@Body BodyOfferDelete body);
}
