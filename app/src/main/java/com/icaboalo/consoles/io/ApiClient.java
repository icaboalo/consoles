package com.icaboalo.consoles.io;

import com.icaboalo.consoles.io.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by icaboalo on 6/05/16.
 */
public class ApiClient {

    public static ApiService mApiService;

    public static ApiService getApiService() {
        if (mApiService == null){
            Retrofit nRetrofit = new Retrofit.Builder()
                    .baseUrl("http://pxzstudios.com/dummy/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mApiService = nRetrofit.create(ApiService.class);
        }
        return mApiService;
    }

}
