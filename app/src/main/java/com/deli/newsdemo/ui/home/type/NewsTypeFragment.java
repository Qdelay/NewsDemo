package com.deli.newsdemo.ui.home.type;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.deli.newsdemo.R;
import com.deli.newsdemo.adapter.NewsRcAdapter;
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
    @BindView(R.id.rc_news)
    RecyclerView mRcNews;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_type);
        unbinder = ButterKnife.bind(this, getContentView());
    }

    @Override
    public void initView() {
        super.initView();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            data.add(String.valueOf(i));
        }
        NewsRcAdapter adapter = new NewsRcAdapter(getActivity(), data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcNews.setLayoutManager(layoutManager);
        mRcNews.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
