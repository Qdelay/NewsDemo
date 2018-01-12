package com.deli.newsdemo.mvpframe.base;

/**
 * Created by Administrator on 2016/12/31.
 */

public interface BaseView {

    //void showError(String msg);

    void onRequestStart();

    void onRequestError(String msg);

    void onRequestEnd();

    void onInternetError();
}
