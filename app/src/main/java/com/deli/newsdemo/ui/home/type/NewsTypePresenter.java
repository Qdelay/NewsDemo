package com.deli.newsdemo.ui.home.type;

import android.util.Log;

import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.rx.NetworkSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:15
 * @describe :
 */

public class NewsTypePresenter extends NewsTypeContract.Presenter {
    private static final String TAG = "NewsTypePresenter";

    /**
     * .subscribeOn(Schedulers.newThread())//指定 subscribe() 发生在新的线程
     * .observeOn(AndroidSchedulers.mainThread())// 指定 Subscriber 的回调发生在主线程
     */
    @Override
    public void getNews() {
        Log.d(TAG, "getNews: ");
        mRxManager.add(mModel.getNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new NetworkSubscriber<NewsHeadlineEntity>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.d(TAG, "onError: " + e.getMessage());
                        if (e.getMessage().contains("403")) {
                            getNews();
                        }
                    }

                    @Override
                    public void onNext(NewsHeadlineEntity newsHeadlineEntity) {
                        Log.d("onCompleted", "onCompleted: " + newsHeadlineEntity.getT1348647853363().get(0).getImgsrc());
                        mView.refreshData(newsHeadlineEntity.getT1348647853363());
                    }
                }));
    }

    @Override
    public void clearRequest() {
        mRxManager.clearRequest();
    }
}
