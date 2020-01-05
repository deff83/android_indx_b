package com.example.index;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.index.Models.AddDelOffer.AddOffer;
import com.example.index.Models.ApiContext;
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
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.HistoryTrading.HistoryTrading_Responce;
import com.example.index.Models.HistoriTransaction.HistoryTransaction_Responce;
import com.example.index.Models.Enums.IsBid;
import com.example.index.Models.Enums.KindTick;
import com.example.index.Models.AddDelOffer.OfferAdd_Responce;
import com.example.index.Models.AddDelOffer.OfferDelete_Responce;
import com.example.index.Models.OfferList.OfferList_Responce;
import com.example.index.Models.OfferMy.OfferMy_Responce;
import com.example.index.Models.Tick.Responce_tick;
import com.example.index.Models.Shifr;
import com.example.index.Models.Tick.TickBody;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.Models.HistoryTrading.Trading;
import com.example.index.Models.HistoryTrading.TradingHistoryTrading;
import com.example.index.repositories.ResatAPIClient;
import com.example.index.repositories.RetrofitService;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";

    @Test
    public void get_OfferList() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();

        BodyOfferList bodyOfferList = new BodyOfferList(
                new ApiContext(),
                new Trading(60)
        );
        Response<OfferList_Responce> response = resatAPIClient.getOfferList(bodyOfferList).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_Tools() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();

        BodyTools bodyOfferList = new BodyTools(
                new ApiContext()
        );
        Response<Tools_Responce> response = resatAPIClient.getTools(bodyOfferList).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_Balance() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();

        BodyBalance bodyOfferList = new BodyBalance(
                new ApiContext()
        );
        Response<Balance_Responce> response = resatAPIClient.getBalance(bodyOfferList).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_HistoryTrading() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        BodyHistoryTrading bodyHistoryTrading = new BodyHistoryTrading(
                new ApiContext(),
                new TradingHistoryTrading(60, "20191230", "20200102")
        );
        Response<HistoryTrading_Responce> response = resatAPIClient.getHistoryTrading(bodyHistoryTrading).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_HistoryTransaction() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        BodyHistoryTransaction bodyHistoryTransaction = new BodyHistoryTransaction(
                new ApiContext(),
                new TradingHistoryTrading(60, "20191230", "20200102")
        );
        Response<HistoryTransaction_Responce> response = resatAPIClient.getHistoryTransaction(bodyHistoryTransaction).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_OfferMy() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        BodyOfferMy bodyOfferMy = new BodyOfferMy(
                new ApiContext()
        );
        Response<OfferMy_Responce> response = resatAPIClient.getOfferMy(bodyOfferMy).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_tick() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        BodyTick bodyTick = new BodyTick(
                new ApiContext(),
                new TickBody(60, KindTick.DAY.getKind())
        );
        Response<Responce_tick> response = resatAPIClient.getTick(bodyTick).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_OfferAdd() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        BodyOfferAdd bodyOfferAdd = new BodyOfferAdd(
                new ApiContext(),
                new AddOffer(60, 1, true, IsBid.BUY.isBid(), 1.0)
        );
        Response<OfferAdd_Responce> response = resatAPIClient.getOfferAdd(bodyOfferAdd).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }

    @Test
    public void get_OfferDelete() throws IOException {
        ResatAPIClient resatAPIClient = new RetrofitService().getResatAPIClient();
        String sign = new Shifr.Builder().set_offerid(1223131).build().base64_shifr(EnumIndex.OFFERDELETE);
        Log.d(TAG, sign);
        BodyOfferDelete bodyOfferDelete = new BodyOfferDelete(
                new ApiContext(),
                1223131
        );
        Response<OfferDelete_Responce> response = resatAPIClient.getOfferDelete(bodyOfferDelete).execute();

        assertEquals("OK", response.message());
        assertEquals(0, response.body().getCode());
        Log.d(TAG, response.body().toString());
    }


}
