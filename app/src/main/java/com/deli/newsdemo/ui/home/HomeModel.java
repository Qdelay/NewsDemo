package com.deli.newsdemo.ui.home;

import com.deli.newsdemo.api.Network;
import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:14
 * @describe :
 */

public class HomeModel implements HomeContract.Model {
    @Override
    public Observable<NewsHeadlineEntity> getNews() {
        return Network.getInstance()
                .getResultApi()
                .getHeadlineNews()
                .compose(RxSchedulerHelper.<NewsHeadlineEntity>io_main());
    }
}
