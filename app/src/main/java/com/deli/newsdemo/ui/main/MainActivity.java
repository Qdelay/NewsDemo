package com.deli.newsdemo.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;
import com.deli.newsdemo.widget.navigation.BottomNavigation;
import com.deli.newsdemo.widget.navigation.BottomNavigationBean;

public class MainActivity extends BaseFrameActivity<MainPresenter, MainModel> implements MainContract.View, BottomNavigation.onClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        super.initView();
        BottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setItemClickListener(this);
        bottomNavigation.addItem(new BottomNavigationBean(R.drawable.vector_drawable_home, R.drawable.vector_drawable_home_active, R.string.home)).
                addItem(new BottomNavigationBean(R.drawable.vector_drawable_video, R.string.video)).
                addItem(new BottomNavigationBean(R.drawable.vector_drawable_mine, R.drawable.vector_drawable_mine_active, R.string.mine)).
                setActiveColor(R.color.red).
                setBgColor(R.color.colorPrimary).
                setPosition(0).
                initilize();
    }

    @Override
    public void onClick(int position) {
        Log.d(TAG, "onClick: " + position);
    }
}
