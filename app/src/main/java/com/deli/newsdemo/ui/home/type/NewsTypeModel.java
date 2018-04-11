package com.deli.newsdemo.ui.home.type;

import com.deli.newsdemo.api.Network;
import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:14
 * @describe :
 */

public class NewsTypeModel implements NewsTypeContract.Model {
    @Override
    public Observable<NewsHeadlineEntity> getNews(int startPage, int endPage) {
        return Network.getInstance()
                .getNetEaseResultApi()
                .getHeadlineNews(startPage, endPage)
                .compose(RxSchedulerHelper.<NewsHeadlineEntity>io_main());
    }
}
