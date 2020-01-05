package com.example.index.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.index.Models.ApiContext;
import com.example.index.Models.HistoryTrading.Trading;
import com.example.index.Models.OfferList.BodyOfferList;
import com.example.index.Models.OfferList.OfferList_Responce;
import com.example.index.Models.Tools.BodyTools;
import com.example.index.Models.Tools.Tool;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.repositories.DBLive;
import com.example.index.repositories.ResatAPIClient;
import com.example.index.repositories.RetrofitService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";

    private MutableLiveData<Tools_Responce> tools_responceMutableLiveData;
    private MutableLiveData<OfferList_Responce> offerList_responceMutableLiveData;

    private DBLive dbLive;
    private Timer timer_tool, timer_offer_list;
    private ResatAPIClient resatAPIClient;
    private Map<Integer, String> mapCoin = new HashMap<>();

    private int tekCoin = 60;

    public HomeViewModel() {
        dbLive = DBLive.getInstance();
        tools_responceMutableLiveData = new MutableLiveData<>();
        offerList_responceMutableLiveData = new MutableLiveData<>();
        resatAPIClient = new RetrofitService().getResatAPIClient();

    }

    public void set_tools_timer(){
        if(timer_tool == null) {
            timer_tool = new Timer();
            timer_tool.schedule(new Timer_Tool(), 1000,2000);
        }
    }

    public void set_offer_timer(){
        if(timer_offer_list == null) {
            timer_offer_list = new Timer();
            timer_offer_list.schedule(new Timer_OfferList(), 2000, 1000);
        }
    }



    public void cancel_tools_timer(){
        timer_tool.cancel();
        timer_tool = null;
        Log.d(TAG, "cancel_tools_timer: ");
    }

    public void cancel_timer(){
        try {
            timer_tool.cancel();
            timer_tool = null;
        }catch (Exception e){}
        try {
            timer_offer_list.cancel();
            timer_offer_list = null;
        }catch (Exception e){}

    }

    public LiveData<Tools_Responce> getTools_responceMutableLiveData() {
        return tools_responceMutableLiveData;
    }

    public MutableLiveData<OfferList_Responce> getOfferList_responceMutableLiveData() {
        return offerList_responceMutableLiveData;
    }

    public void clear_OfferList(){
        offerList_responceMutableLiveData.postValue(new OfferList_Responce());
    }

    public int getTekCoin() {
        return tekCoin;
    }

    public void setTekCoin(int tekCoin) {
        this.tekCoin = tekCoin;
    }

    class Timer_Tool extends TimerTask{

        @Override
        public void run() {
            try {
                BodyTools bodyOfferList = new BodyTools(
                        new ApiContext()
                );
                Response<Tools_Responce> response = resatAPIClient.getTools(bodyOfferList).execute();
                tools_responceMutableLiveData.postValue(response.body());
                List<Tool> list = response.body().getToolList();
                for (int i = 0; i < list.size(); i++) {
                    Tool tool = list.get(i);
                    mapCoin.put(tool.getId(), tool.getName());
                }
                Log.d(TAG, "run: "+response.body());
            }catch (IOException e){
                Log.d(TAG, "exception: "+e.getMessage());
            }
        }
    }
    class Timer_OfferList extends TimerTask{

        @Override
        public void run() {
            try {

                if (mapCoin.size()==0){
                    new Timer_Tool().run();
                }

                BodyOfferList bodyOfferList = new BodyOfferList(
                        new ApiContext(),
                        new Trading(tekCoin)
                );
                Response<OfferList_Responce> response = resatAPIClient.getOfferList(bodyOfferList).execute();
               if(mapCoin.containsKey(tekCoin))response.body().setName(mapCoin.get(tekCoin));
                response.body().setIdCoin(tekCoin);
                offerList_responceMutableLiveData.postValue(response.body());
                Log.d(TAG, "run: "+response.body());
            }catch (IOException e){
                Log.d(TAG, "exception: "+e.getMessage());
            }
        }
    }


}