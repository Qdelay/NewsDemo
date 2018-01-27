package com.deli.newsdemo.ui.home.type;

import android.os.Bundle;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 01369557 on 2018/1/27.
 */

public class NewsTypeFragment extends BaseFrameFragment<NewsTypePresenter, NewsTypeModel>
        implements NewsTypeContract.View {
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_type);
        unbinder = ButterKnife.bind(this, getContentView());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
