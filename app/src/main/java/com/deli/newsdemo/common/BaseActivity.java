package com.deli.newsdemo.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.deli.newsdemo.util.ToastUtils;

/**
 * Created by yiyi on 2016/12/26.
 */

public class BaseActivity extends AppCompatActivity implements BaseFuncIml, View.OnClickListener {

    private static final String TAG = "BaseActivity";

//    public ThemeUtil mThemeUtil;

    private int mFragmentId;

    protected Fragment mCurrFragment;

    private boolean isExit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        initTheme();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initData();
        initView();
        initListener();
        initLoad();
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initLoad() {
    }

    @Override
    public void onClick(View view) {

    }

    public void setFragmentId(int fragmentId) {
        mFragmentId = fragmentId;
    }

    public Fragment getCurrFragment() {
        return mCurrFragment;
    }

    public void setCurrFragment(Fragment currFragment) {
        this.mCurrFragment = currFragment;
    }

    protected void toFragment(Fragment toFragment) {
        if (mCurrFragment == null) {
            ToastUtils.showToast(this, "mCurrFragment is null");
            return;
        }

        if (toFragment == null) {
            ToastUtils.showToast(this, "toFragment is null");
            return;
        }

        if (toFragment.isAdded()) {
            getSupportFragmentManager()
                    .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .hide(mCurrFragment)
                    .show(toFragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .hide(mCurrFragment)
                    .add(mFragmentId, toFragment)
                    .show(toFragment)
                    .commit();
        }
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameter) {
        Intent intent = new Intent(this, toActivity);
        if (parameter != null) {
            intent.putExtras(parameter);
        }
        startActivity(intent);
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
