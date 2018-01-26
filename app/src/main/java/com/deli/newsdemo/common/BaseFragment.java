package com.deli.newsdemo.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deli.newsdemo.util.ToastUtils;
import com.deli.newsdemo.widget.header.HeadBanner;

public class BaseFragment extends Fragment implements BaseFuncIml {
    private View mContentView;
    private ViewGroup container;
    private Fragment mCurrentFragment;
    private HeadBanner mHeadBanner;
    private int mFragmentId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        initView();
        initListener();
        initLoad();
        this.container = container;
        return mContentView;
    }

    public View getContentView() {
        return mContentView;
    }

    public void setContentView(int viewId) {
        this.mContentView = getActivity().getLayoutInflater().inflate(viewId, container, false);
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

    public void setFragmentId(int fragmentId) {
        mFragmentId = fragmentId;
    }

    public void toFragemnt(Fragment toFragment) {
        if (mCurrentFragment == null) {
            mCurrentFragment = toFragment;
            return;
        }

        if (toFragment == null) {
            ToastUtils.showToast(getActivity(), "toFragment is null");
            return;
        }

        if (toFragment.isAdded()) {
            getChildFragmentManager()
                    .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .hide(mCurrentFragment)
                    .show(toFragment)
                    .commit();
        } else {
            getChildFragmentManager()
                    .beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .hide(mCurrentFragment)
                    .add(mFragmentId, toFragment)
                    .show(toFragment)
                    .commit();
        }
    }

    public void setCurrentFragment(Fragment fragment) {
        mCurrentFragment = fragment;
    }

    public Fragment getmCurrentFragment() {
        return mCurrentFragment;
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity) {
        openActivity(toActivity, null);
    }

    protected void openActivity(Class<? extends BaseActivity> toActivity, Bundle parameters) {
        Intent intent = new Intent(getActivity(), toActivity);
        if (parameters != null) {
            intent.putExtras(parameters);
        }
        startActivity(intent);
    }

}
