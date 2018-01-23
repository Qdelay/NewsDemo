package com.deli.newsdemo.ui.main.f_main;

import com.deli.newsdemo.mvpframe.base.BaseModel;
import com.deli.newsdemo.mvpframe.base.BasePresenter;
import com.deli.newsdemo.mvpframe.base.BaseView;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:14
 * @describe :
 */

public interface MainContainerContract {
    interface Model extends BaseModel {

    }

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<Model, View> {

    }
}
