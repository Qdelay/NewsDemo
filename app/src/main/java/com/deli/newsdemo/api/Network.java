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
    private static final String TAG = "Network";

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
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
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
