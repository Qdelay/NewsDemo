package com.deli.newsdemo.rx;

import com.deli.newsdemo.util.NetworkUtils;
import com.deli.newsdemo.util.ToastUtils;

import rx.Subscriber;

/**
 * Created by qiudeli on 2018/2/28.
 */

public abstract class NetworkSubscriber<T> extends Subscriber<T> {
    @Override
    public void onError(Throwable e) {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showToast("wrong net");
            return;
        }
    }
}
