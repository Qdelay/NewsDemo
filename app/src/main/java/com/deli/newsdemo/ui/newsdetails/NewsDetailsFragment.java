package com.deli.newsdemo.ui.newsdetails;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.FragmentMessageCallback;
import com.deli.newsdemo.ui.main.MainActivity;
import com.deli.newsdemo.widget.header.HeadBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.deli.newsdemo.ui.main.MainActivity.ADD_NEWS_PAGE;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class NewsDetailsFragment extends BaseFrameFragment<NewsDetailsPresenter, NewsDetailsModel>
        implements NewsDetailsContract.View {

    public static final String NEW_DETAILS_LEFT_CALLBACK = "new_details_left";
    public static final String NEW_DETAILS_RIGHT_CALLBACK = "new_details_right";
    @BindView(R.id.head_banner)
    HeadBanner headBanner;

    public static final String TAG = "NewsDetailsFragment";

    private FragmentMessageCallback mCallback;

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
        headBanner.setBannerButtonListener(new HeadBanner.BannerBtnClick() {
            @Override
            public void onLeftBtnClick() {
                mCallback.onMessage(null, ADD_NEWS_PAGE);
            }

            @Override
            public void onRightBtnClick() {
                mCallback.onMessage(null, NEW_DETAILS_RIGHT_CALLBACK);
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
