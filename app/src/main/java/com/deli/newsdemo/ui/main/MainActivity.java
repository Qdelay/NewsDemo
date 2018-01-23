package com.deli.newsdemo.ui.main;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;
import com.deli.newsdemo.ui.home.HomeFragment;

public class MainActivity extends BaseFrameActivity<MainPresenter, MainModel> implements MainContract.View {

    private static final String TAG = "MainActivity";

    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentId(R.id.container);
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
        mHomeFragment = new HomeFragment();
        setCurrFragment(mHomeFragment);
        toFragment(mHomeFragment);
    }
}
