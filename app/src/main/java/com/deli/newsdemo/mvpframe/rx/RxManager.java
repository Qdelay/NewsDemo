package com.deli.newsdemo.mvpframe.rx;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/12/31.
 */

public class RxManager {
    public RxBus mRxBus = RxBus.$();
    private Map<String, Observable<?>> mObservables = new HashMap<>();// 管理观察源
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();// 管理订阅者

    public void on(String eventName, Action1<Object> action1) {
        Observable<?> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        mCompositeSubscription
                .add(mObservable.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(action1, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }));
    }

    public void add(Subscription m) {
        mCompositeSubscription.add(m);
    }

    public void clear() {
        mCompositeSubscription.clear();
        mCompositeSubscription.unsubscribe();// 取消订阅
        for (Map.Entry<String, Observable<?>> entry : mObservables.entrySet()) {
            mRxBus.unregister(entry.getKey(), entry.getValue());// 移除观察
        }
    }

    public void clearRequest() {
        //使用CompositeSubscription.clear()方法，它与unsubscribe方法几乎一模一样，
        // 都会对添加的元素进行解绑，而唯一不同的地方就是clear掉了之后该CompositeSubscription还可以继续使用。
        mCompositeSubscription.clear();
    }

    public void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }
}
