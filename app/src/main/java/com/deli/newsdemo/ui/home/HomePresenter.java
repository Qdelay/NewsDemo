package com.deli.newsdemo.ui.home;

import android.util.Log;

import com.deli.newsdemo.entity.NewsHeadlineEntity;

import rx.Subscriber;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:15
 * @describe :
 */

public class HomePresenter extends HomeContract.Presenter {
    @Override
    public void getNews() {
        mRxManager.add(mModel.getNews()
                .subscribe(new Subscriber<NewsHeadlineEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsHeadlineEntity newsHeadlineEntity) {
                        Log.d("onCompleted", "onCompleted: " + newsHeadlineEntity.getT1348647853363().get(0).getImgsrc());
                    }
                }));
    }
}
