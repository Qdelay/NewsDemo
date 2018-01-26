package com.deli.newsdemo.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deli.newsdemo.R;
import com.deli.newsdemo.widget.button.NoDoubleClickListener;

/**
 * Created by 01369557 on 2018/1/25.
 * 顶部Banner
 */

public class HeadBanner extends RelativeLayout {

    private View mContainerView;

    private BannerBtnClick mBannerBtnClick;

    private LinearLayout btn_left;

    private LinearLayout btn_right;

    private TextView tv_header_title;

    public HeadBanner(Context context) {
        this(context, null);
    }

    public HeadBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HeadBanner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initListener();
    }

    private void initListener() {
        btn_left.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                mBannerBtnClick.onLeftBtnClick();
            }
        });

        btn_right.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                mBannerBtnClick.onRightBtnClick();
            }
        });
    }

    private void init() {
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        mContainerView = inflater.inflate(R.layout.layout_head_banner, this, true);
        btn_left = mContainerView.findViewById(R.id.btn_left);
        btn_right = mContainerView.findViewById(R.id.btn_right);
        tv_header_title = mContainerView.findViewById(R.id.tv_header_title);
    }

    public LinearLayout getBtn_left() {
        return btn_left;
    }

    public LinearLayout getBtn_right() {
        return btn_right;
    }

    public void setBannerButtonListener(BannerBtnClick bannerBtnClick) {
        this.mBannerBtnClick = bannerBtnClick;
    }

    public void setTitle(String title) {
        tv_header_title = mContainerView.findViewById(R.id.tv_header_title);
        this.tv_header_title.setText(title);
    }

    public interface BannerBtnClick {
        void onLeftBtnClick();

        void onRightBtnClick();
    }
}
