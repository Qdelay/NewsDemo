package com.deli.newsdemo.ui.video;

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

public class VideoFragment extends BaseFrameFragment<VideoPresenter, VideoModel>
        implements VideoContract.View {
    @BindView(R.id.head_banner)
    HeadBanner mHeadBanner;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_video);
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
        mHeadBanner.getBtn_left().setVisibility(View.GONE);
        mHeadBanner.getBtn_right().setVisibility(View.GONE);
        mHeadBanner.setTitle(getString(R.string.video));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}