package com.example.index;

import android.content.Intent;
import android.os.IBinder;

import androidx.lifecycle.LifecycleService;

import com.example.index.Models.ApiContext;
import com.example.index.Models.Enums.EnumIndex;
import com.example.index.Models.HistoryTrading.BodyHistoryTrading;
import com.example.index.Models.HistoryTrading.HistoryTrading_Responce;
import com.example.index.Models.HistoryTrading.TradingHistoryTrading;
import com.example.index.Models.Tools.BodyTools;
import com.example.index.Models.Tools.Tools_Responce;
import com.example.index.Models.balance.Balance_Responce;
import com.example.index.Models.balance.BodyBalance;
import com.example.index.repositories.DBLive;
import com.example.index.repositories.ResatAPIClient;
import com.example.index.repositories.RetrofitService;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Response;

public class IndexService extends LifecycleService {

    private Timer timerIndex = new Timer();
    private DBLive dbLive;
    private ResatAPIClient resatAPIClient;

    public IndexService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        super.onBind(intent);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dbLive = DBLive.getInstance();
        resatAPIClient = new RetrofitService().getResatAPIClient();
        timerIndex.schedule(new TimerIndex(), 2000, 2000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class TimerIndex extends TimerTask{
        private EnumIndex tekUpdate = EnumIndex.BALANCE;
        @Override
        public void run() {
            Params params = dbLive.getParams();
            try {
                if (params.isBalance() && tekUpdate == EnumIndex.HISTORYTRADING) {
                    BodyBalance bodyOfferList = new BodyBalance(
                            new ApiContext()
                    );
                    Response<Balance_Responce> response = resatAPIClient.getBalance(bodyOfferList).execute();

                    if (!response.isSuccessful()) {
                        System.out.println("response.body()==null Balance_Responce");
                        return;
                    }

                    dbLive.setBalance_responceMutableLiveData(response.body());
                    tekUpdate = EnumIndex.BALANCE;
                    return;
                }
                if (!params.isBalance()) tekUpdate = EnumIndex.BALANCE;

                /*if (params.isToolBar() && tekUpdate == EnumIndex.BALANCE) {
                    BodyTools bodyOfferList = new BodyTools(
                            new ApiContext()
                    );
                    Response<Tools_Responce> response = resatAPIClient.getTools(bodyOfferList).execute();
                    dbLive.setTools_responceMutableLiveData(response.body());
                    tekUpdate = EnumIndex.TOOLS;
                    return;
                }
                if (!params.isToolBar()) tekUpdate = EnumIndex.TOOLS;*/


                if (params.isHistoryTrading() && tekUpdate == EnumIndex.BALANCE) {
                    BodyHistoryTrading bodyHistoryTrading = new BodyHistoryTrading(
                            new ApiContext(),
                            new TradingHistoryTrading(60, "20191230", "20200102")
                    );
                    Response<HistoryTrading_Responce> response = resatAPIClient.getHistoryTrading(bodyHistoryTrading).execute();

                    if (!response.isSuccessful()) {
                        System.out.println("response.body()==null HistoryTrading_Responce");
                        return;
                    }

                    dbLive.setHistoryTrading_responceMutableLiveData(response.body());
                    tekUpdate = EnumIndex.HISTORYTRADING;
                    return;
                }
                if (!params.isHistoryTrading()) tekUpdate = EnumIndex.HISTORYTRADING;




            }catch (IOException e){e.printStackTrace();}
        }
    }
}
