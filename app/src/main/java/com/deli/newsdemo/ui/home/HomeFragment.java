package com.deli.newsdemo.ui.home;

import android.os.Bundle;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.widget.navigation.BottomNavigation;
import com.deli.newsdemo.widget.navigation.BottomNavigationBean;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class HomeFragment extends BaseFrameFragment<HomePresenter, HomeModel>
        implements HomeContract.View, BottomNavigation.onClickListener {

    private static final String TAG = "HomeFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        setFragmentId(R.id.container);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
        BottomNavigation bottomNavigation = getContentView().findViewById(R.id.bottom_navigation);
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
