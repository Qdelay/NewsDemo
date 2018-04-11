package com.deli.newsdemo.ui.home.type;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.deli.newsdemo.R;
import com.deli.newsdemo.adapter.NewsRcAdapter;
import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 01369557 on 2018/1/27.
 * 首页新闻Fragment
 */

public class NewsTypeFragment extends BaseFrameFragment<NewsTypePresenter, NewsTypeModel>
        implements NewsTypeContract.View, Runnable {
    public static final String TAG = "NewsTypeFragment";
    public static final int INT_0 = 0;
    private int mPage = 1;
    @BindView(R.id.rc_news)
    RecyclerView mRcNews;
    @BindView(R.id.rl_loading)
    RelativeLayout mRlLoding;
    @BindView(R.id.refresh)
    SmartRefreshLayout mRefreshLayout;

    private NewsRcAdapter adapter;

    private List<NewsHeadlineEntity.T1348647853363Bean> data = new ArrayList<>();

    private Handler handler = new Handler();
    private boolean isUserVisible = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_type);
        ButterKnife.bind(this, getContentView());
        //防止反复创建adapter
        adapter = new NewsRcAdapter(getActivity(), data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcNews.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRcNews.setLayoutManager(layoutManager);
        mRcNews.setAdapter(adapter);
        initRefreshLayout();
        Log.d(TAG, "onCreate: ");
    }

    private void initRefreshLayout() {
        //设置 Header 为 MaterialHeader
        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        //设置 Footer 为 经典样式
        mRefreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));
        //设置监听
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getNews(INT_0);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getNews(mPage);
            }
        });
    }

    @Override
    public void initView() {
        super.initView();
        Log.d(TAG, "initView: ");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.clearRequest();
    }

    @Override
    public void clearAndRefreshData(List<NewsHeadlineEntity.T1348647853363Bean> bean) {
        Log.d(TAG, "refreshData: " + bean.size());
        data.clear();
        data.addAll(bean);
        mRefreshLayout.finishRefresh();
        setLoadingVisible(false);
        adapter.notifyDataSetChanged();
        mPage = 1;
    }

    @Override
    public void addAndRefreshData(List<NewsHeadlineEntity.T1348647853363Bean> bean) {
        if (!bean.isEmpty()) {
            data.addAll(bean);
            adapter.notifyDataSetChanged();
            mPage += 1;
        }
        mRefreshLayout.finishLoadMore();

    }

    @Override
    public void setLoadingVisible(boolean show) {
        if (show) {
            mRlLoding.setVisibility(View.VISIBLE);
        } else {
            mRlLoding.setVisibility(View.GONE);
        }
    }

    @Override
    public void backToTop() {
        mRcNews.smoothScrollToPosition(INT_0);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isUserVisible = isVisibleToUser;
        if (isUserVisible) {
            Log.d(TAG, "setUserVisibleHint: visible");
            handler = new Handler();
            handler.postDelayed(this, 500);
        } else {
            Log.d(TAG, "setUserVisibleHint: unvisible");
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!isUserVisible) {
            data.clear();
            adapter.notifyDataSetChanged();
            setLoadingVisible(true);
        }
    }

    @Override
    public void run() {
        Log.d(TAG, "setUserVisibleHint: ");
        mPresenter.getNews(INT_0);
    }
}
