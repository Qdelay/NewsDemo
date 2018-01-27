package com.deli.newsdemo.ui.newsdetails;

import android.os.Bundle;
import android.view.View;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.MainActivity;
import com.deli.newsdemo.widget.header.HeadBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class NewsDetailsFragment extends BaseFrameFragment<NewsDetailsPresenter, NewsDetailsModel>
        implements NewsDetailsContract.View {

    @BindView(R.id.head_banner)
    HeadBanner headBanner;

    public static final String TAG = "NewsDetailsFragment";

    private MainActivity mCallback;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_details);
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
        mCallback = (MainActivity) getActivity();
        mCallback.getLoading().setVisibility(View.VISIBLE);
        headBanner.setBannerButtonListener(new HeadBanner.BannerBtnClick() {
            @Override
            public void onLeftBtnClick() {
                NewsDetailsFragment mNewsDetailsFragment = new NewsDetailsFragment();
                mCallback.toFragment(mNewsDetailsFragment);
                mCallback.setCurrFragment(mNewsDetailsFragment);
            }

            @Override
            public void onRightBtnClick() {
                mCallback = (MainActivity) getActivity();
                mCallback.backToFragment();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mCallback.getLoading().setVisibility(View.GONE);
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
