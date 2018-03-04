package com.deli.newsdemo.ui.home.type;

import android.util.Log;

import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.rx.NetworkSubscriber;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:15
 * @describe :
 */

public class NewsTypePresenter extends NewsTypeContract.Presenter {
    private static final String TAG = "NewsTypePresenter";

    @Override
    public void getNews() {
        Log.d(TAG, "getNews: ");
        mRxManager.add(mModel.getNews()
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
