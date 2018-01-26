package com.deli.newsdemo.ui.home;

import android.os.Bundle;
import android.view.View;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.widget.header.HeadBanner;

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

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        unbinder = ButterKnife.bind(this, getContentView());
        setFragmentId(R.id.container);
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
