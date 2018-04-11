package com.deli.newsdemo.api;

import com.deli.newsdemo.global.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/15 09:38
 * @describe :
 */

public class Network {
    private static final String TAG = "Network";

    private static final int DEFAULT_TIMEOUT = 5;

    private volatile static Network singleton;

    public static NetEaseCommonApi mNetEaseCommonApi;

    public static DouBanCommonApi mDouBanCommonApi;

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

    public NetEaseCommonApi getNetEaseResultApi() {
        return mNetEaseCommonApi == null ? configRetrofit(NetEaseCommonApi.class, Constants.NETEASE_API_BASE_URL) : mNetEaseCommonApi;
    }

    public DouBanCommonApi getDouBanResultApi() {
        return mDouBanCommonApi == null ? configRetrofit(DouBanCommonApi.class, Constants.DOUBAN_API_BASE_URL) : mDouBanCommonApi;
    }

    private <T> T configRetrofit(Class<T> service, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(configClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient configClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .removeHeader("User-Agent")
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
                        .build();
                return chain.proceed(newRequest);
            }
        });
        return okHttpClient.build();
    }


//okhttp拦截器
//    private Interceptor mErrorInterceptor = new  Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Log.d(TAG, "intercept: " + NetworkUtils.isAvailableByPing());
//
//            Request oldRequest = chain.request();
//            Response response = chain.proceed(oldRequest);
//            byte[] respBytes = response.body()
//                    .bytes();
//            String respString = new String(respBytes);
//            Log.d(TAG, "intercept: " + respString);
//            return response.newBuilder()
//                    .body(ResponseBody.create(null, respBytes))
//                    .build();//在前面获取bytes的时候response的stream已经被关闭了,要重新生成response
//        }
//    };
}
