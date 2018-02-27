package com.deli.newsdemo.api;

import com.deli.newsdemo.global.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/15 09:38
 * @describe :
 */

public class Network {
    private static final int DEFAULT_TIMEOUT = 5;

    private volatile static Network singleton;

    public static CommonApi mCommonApi;

    private static Retrofit retrofit;

    private Network() {
    }

    public static Network getInstance() {
        if (singleton == null) {
            synchronized (Network.class) {
                if (singleton == null) {
                    singleton = new Network();
                }
            }
        }
        return singleton;
    }

    public CommonApi getResultApi() {
        return mCommonApi == null ? configRetrofit(CommonApi.class) : mCommonApi;
    }

    private <T> T configRetrofit(Class<T> service) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .client(configClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient configClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return okHttpClient.build();
    }
}
