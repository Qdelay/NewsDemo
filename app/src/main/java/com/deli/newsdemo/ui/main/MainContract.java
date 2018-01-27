package com.deli.newsdemo.ui.main;

import com.airbnb.lottie.LottieAnimationView;
import com.deli.newsdemo.mvpframe.base.BaseModel;
import com.deli.newsdemo.mvpframe.base.BasePresenter;
import com.deli.newsdemo.mvpframe.base.BaseView;

/**
 * Created by 01369557 on 2018/1/12.
 */

public interface MainContract {
    interface Model extends BaseModel {
    }

    interface View extends BaseView {
        LottieAnimationView getLoading();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        abstract void getHomeInfo(String name);
    }
}
