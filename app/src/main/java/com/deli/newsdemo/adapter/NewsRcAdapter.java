package com.deli.newsdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.deli.newsdemo.R;
import com.deli.newsdemo.entity.NewsHeadlineEntity;

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
            final NewsHolder newsHolder = (NewsHolder) holder;
            NewsHeadlineEntity.T1348647853363Bean item = (NewsHeadlineEntity.T1348647853363Bean) mData.get(position);
            newsHolder.newsTitle.setText(item.getTitle());
            newsHolder.newsTips.setText(item.getSource());
            Glide.with(mContext)
                    .load(item.getImgsrc())
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            newsHolder.mProgressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(newsHolder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class NewsHolder extends RecyclerView.ViewHolder {
        TextView newsTitle;
        TextView newsTips;
        ImageView mImageView;
        ProgressBar mProgressBar;

        public NewsHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsTips = itemView.findViewById(R.id.tips);
            mImageView = itemView.findViewById(R.id.news_img);
            mProgressBar = itemView.findViewById(R.id.progress);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
