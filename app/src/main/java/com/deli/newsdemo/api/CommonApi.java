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

    /**
     * 获取头条新闻
     *
     * @return NewsHeadlineEntity
     */
    @GET("T1348647853363/0-40.html")
    Observable<NewsHeadlineEntity> getHeadlineNews();

}
