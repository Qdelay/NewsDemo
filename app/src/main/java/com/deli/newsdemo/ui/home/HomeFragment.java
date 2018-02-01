package com.deli.newsdemo.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.deli.newsdemo.R;
import com.deli.newsdemo.adapter.ViewPagerFragmentAdapter;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.home.type.NewsTypeFragment;
import com.deli.newsdemo.widget.header.HeadBanner;
import com.deli.newsdemo.widget.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class HomeFragment extends BaseFrameFragment<HomePresenter, HomeModel>
        implements HomeContract.View {
    @BindView(R.id.head_banner)
    HeadBanner mHeadBanner;
    @BindView(R.id.tl_home)
    TabLayout tl_home;
    @BindView(R.id.vp_home)
    ViewPager vp_home;

    private Unbinder unbinder;

    private int oldPosition = 0;

    private List<Fragment> mFragments;

    private ViewPagerFragmentAdapter mViewPagerFragmentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        unbinder = ButterKnife.bind(this, getContentView());
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
        mHeadBanner.setTitle(getString(R.string.home));
        mHeadBanner.getBtn_left().setVisibility(View.GONE);
        mHeadBanner.getBtn_right().setVisibility(View.GONE);
        mFragments = new ArrayList<>();
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mFragments.add(new NewsTypeFragment());
        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), mFragments);
        vp_home.setAdapter(mViewPagerFragmentAdapter);
        tl_home.setupWithViewPager(vp_home);
        tl_home.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp_home.setCurrentItem(tab.getPosition(), false);
//                    vp_home.setCurrentItem(tab.getPosition());

                oldPosition = tab.getPosition();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
