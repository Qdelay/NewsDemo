package com.deli.newsdemo.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;
import com.deli.newsdemo.ui.main.f_main.MainContainerFragment;
import com.deli.newsdemo.ui.mine.MineFragment;

public class MainActivity extends BaseFrameActivity<MainPresenter, MainModel> implements MainContract.View, FragmentMssageListener {

    private static final String TAG = "MainActivity";

    private MainContainerFragment mHomeFragment;

    @Override
    public void onMessage(Bundle bundle) {
        Log.d(TAG, "onMessage: " + bundle.getString(MineFragment.TAG));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentId(R.id.container);
    }

    @Override
    public void initView() {
        super.initView();
        mHomeFragment = new MainContainerFragment();
        setCurrFragment(mHomeFragment);
        toFragment(mHomeFragment);
    }

    @Override
    public void initData() {
        super.initData();
    }
}
