package com.deli.newsdemo.ui.main.f_main;

import android.os.Bundle;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.global.Constants;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.home.HomeFragment;
import com.deli.newsdemo.ui.mine.MineFragment;
import com.deli.newsdemo.ui.video.VideoFragment;
import com.deli.newsdemo.widget.navigation.BottomNavigation;
import com.deli.newsdemo.widget.navigation.BottomNavigationBean;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class MainContainerFragment extends BaseFrameFragment<MainContainerPresenter, MainContainerModel>
        implements MainContainerContract.View, BottomNavigation.onClickListener {

    public static final String TAG = "MainContainerFragment";

    private HomeFragment mHomeFragment;

    private MineFragment mMineFragment;

    private VideoFragment mVideoFragment;

    private int oldPosition = Constants.pageNum.Home;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        setFragmentId(R.id.container);
    }

    @Override
    public void initData() {
        super.initData();
        mHomeFragment = new HomeFragment();
        mMineFragment = new MineFragment();
        mVideoFragment = new VideoFragment();
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
        toFragemnt(mHomeFragment);
        setCurrentFragment(mHomeFragment);
    }

    @Override
    public void onClick(int position) {
        Log.d(TAG, "onClick: " + position);
        if (oldPosition == position) {
            return;
        }
        switch (position) {
            case Constants.pageNum.Home:
                toFragemnt(mHomeFragment);
                setCurrentFragment(mHomeFragment);
                break;
            case Constants.pageNum.Mine:
                toFragemnt(mMineFragment);
                setCurrentFragment(mMineFragment);
                break;
            case Constants.pageNum.Video:
                toFragemnt(mVideoFragment);
                setCurrentFragment(mVideoFragment);
                break;
            default:
                break;
        }
        oldPosition = position;
    }
}
