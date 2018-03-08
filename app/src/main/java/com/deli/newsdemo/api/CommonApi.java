package com.deli.newsdemo.api;

import com.deli.newsdemo.entity.NewsHeadlineEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/15 09:36
 * @describe :
 */

public interface CommonApi {

//    @GET("T1348647853363/0-20.html")
//    Observable<NewsHeadlineEntity> getHeadlineNews();

    @GET("v2/movie/top250?start=25&count=25")
    Observable<NewsHeadlineEntity> getHeadlineNews();

}
