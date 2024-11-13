package com.rajvardhan.mobileapplication.activities.utlis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private API api;

    private static RetrofitClient retrofitClient = null;

    private RetrofitClient(){
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API.class);
    }

    public static RetrofitClient getInstance(){
        if(retrofitClient==null)
            retrofitClient = new RetrofitClient();
        return  retrofitClient;
    }

    public API getApi() {
        return api;
    }
}
