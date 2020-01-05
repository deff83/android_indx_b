package com.example.index.repositories;

import com.example.index.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private ResatAPIClient resatAPIClient;

    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        resatAPIClient = retrofit.create(ResatAPIClient.class);
    }

    public ResatAPIClient getResatAPIClient(){
        return resatAPIClient;
    }

}
