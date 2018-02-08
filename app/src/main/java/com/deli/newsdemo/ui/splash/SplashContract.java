package com.deli.newsdemo.ui.splash;

import com.deli.newsdemo.mvpframe.base.BaseModel;
import com.deli.newsdemo.mvpframe.base.BasePresenter;
import com.deli.newsdemo.mvpframe.base.BaseView;

/**
 * Created by 01369557 on 2018/1/12.
 */

public interface SplashContract {
    interface Model extends BaseModel {
    }

    interface View extends BaseView {
    }

    abstract class Presenter extends BasePresenter<Model, View> {
    }
}
