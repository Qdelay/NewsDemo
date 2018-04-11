package com.deli.newsdemo.api;

import com.deli.newsdemo.entity.NewsHeadlineEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/15 09:36
 * @describe :
 */

public interface DouBanCommonApi {

    /**
     * 获取头条新闻
     *
     * @return NewsHeadlineEntity
     */
    @GET("T1348647853363/{startPage}-{endPage}.html")
    Observable<NewsHeadlineEntity> getHeadlineNews(@Path("startPage") int starPage, @Path("endPage") int endPage);

}
