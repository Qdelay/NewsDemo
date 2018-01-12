package com.deli.newsdemo.ui.main;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;

public class MainActivity extends BaseFrameActivity<MainPresenter, MainModel> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
