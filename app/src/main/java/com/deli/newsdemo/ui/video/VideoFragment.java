package com.deli.newsdemo.ui.video;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class VideoFragment extends BaseFrameFragment<VideoPresenter, VideoModel>
        implements VideoContract.View {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_video);
        setFragmentId(R.id.container);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
    }
}