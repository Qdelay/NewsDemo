package com.deli.newsdemo.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;
import com.deli.newsdemo.ui.main.f_main.MainContainerFragment;
import com.deli.newsdemo.ui.mine.MineFragment;
import com.deli.newsdemo.ui.newsdetails.NewsDetailsFragment;

public class MainActivity extends BaseFrameActivity<MainPresenter, MainModel> implements MainContract.View, FragmentMssageListener {

    private static final String TAG = "MainActivity";

    private MainContainerFragment mMainFragment;

    private NewsDetailsFragment mNewsDetailsFragment;

    @Override
    public void onMessage(Bundle bundle, String tag) {
        switch (tag) {
            case MineFragment.TAG:
                toFragment(mNewsDetailsFragment);
                setCurrFragment(mNewsDetailsFragment);
                break;
            case NewsDetailsFragment.TAG:
                NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
                toFragment(newsDetailsFragment);
                setCurrFragment(newsDetailsFragment);
                break;
            case "back":
                backToFragment();
                break;
            default:
                break;

        }
        Log.d(TAG, "onMessage: " + tag);
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
        mMainFragment = new MainContainerFragment();
        mNewsDetailsFragment = new NewsDetailsFragment();
        setCurrFragment(mMainFragment);
        toFragment(mMainFragment);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
