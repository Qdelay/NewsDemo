package com.deli.newsdemo.ui.home.type;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.deli.newsdemo.R;
import com.deli.newsdemo.adapter.NewsRcAdapter;
import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 01369557 on 2018/1/27.
 */

public class NewsTypeFragment extends BaseFrameFragment<NewsTypePresenter, NewsTypeModel>
        implements NewsTypeContract.View {
    public static final String TAG = "NewsTypeFragment";
    @BindView(R.id.rc_news)
    RecyclerView mRcNews;

    private Unbinder unbinder;

    private NewsRcAdapter adapter;

    private List<NewsHeadlineEntity.T1348647853363Bean> data = new ArrayList<>();

    private boolean isUiVisible = false;

    private boolean isUserVisible = false;

    private boolean isFirstLoad = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_type);
        unbinder = ButterKnife.bind(this, getContentView());
        adapter = new NewsRcAdapter(getActivity(), data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcNews.setLayoutManager(layoutManager);
        mRcNews.setAdapter(adapter);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();

        if (isFirstLoad) {
            mPresenter.getNews();
            isFirstLoad = false;
        }
        Log.d(TAG, "initView: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void refreshData(List<NewsHeadlineEntity.T1348647853363Bean> bean) {
        Log.d(TAG, "refreshData: " + bean.size());
        data.clear();
        data.addAll(bean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isUserVisible = isVisibleToUser;
        if (isUserVisible && !isFirstLoad) {
            mPresenter.getNews();
        }
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
    }
}
