package com.deli.newsdemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 01369557 on 2018/1/27.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragments;
    private String[] titles = {"页面123", "页面2", "页面3", "页面1", "页面2222", "页面3", "页面33331", "页面2", "页面3"};

    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
