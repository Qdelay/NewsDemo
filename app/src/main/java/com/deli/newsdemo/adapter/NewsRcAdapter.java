package com.deli.newsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deli.newsdemo.R;

import java.util.List;

/**
 * Created by qiudeli on 2018/2/9.
 */

public class NewsRcAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List mData;
    private Context mContext;

    public NewsRcAdapter(Context context, List data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rc_news_type_container, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NewsHolder) {
            NewsHolder newsHolder = (NewsHolder) holder;
            newsHolder.newsTitle.setText("hello" + mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;

        public NewsHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
