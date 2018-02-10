package com.deli.newsdemo.ui.home;

import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.base.BaseModel;
import com.deli.newsdemo.mvpframe.base.BasePresenter;
import com.deli.newsdemo.mvpframe.base.BaseView;

import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:14
 * @describe :
 */

public interface HomeContract {
    interface Model extends BaseModel {

        Observable<NewsHeadlineEntity> getNews();

    }
    interface View extends BaseView {
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getNews();
    }
}
