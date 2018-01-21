package com.deli.newsdemo.widget.navigation;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deli.newsdemo.R;
import com.deli.newsdemo.util.SvgUtils;

/**
 * Created by 01369557 on 2018/1/19.
 *
 * 与bean绑定数据，更新数据
 */

public class NavigationItem extends LinearLayout {

    private ImageView iv_Tab;
    private TextView tv_Tab;
    private int imageRes;
    private int activeImageRes;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public NavigationItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initItem(context);
    }

    public NavigationItem(Context context) {
        this(context, null);
    }

    private void initItem(Context context) {
        LayoutInflater itemInflater = LayoutInflater.from(context);
        View itemView = itemInflater.inflate(R.layout.bottom_navigation_bar_item, this, true);
        iv_Tab = itemView.findViewById(R.id.iv_tab);
        tv_Tab = itemView.findViewById(R.id.tv_tab);
    }

    public void setTitle(int stringRes) {
        tv_Tab.setText(getResources().getString(stringRes));
    }

    public void setWidth(int mWidth) {
        setLayoutParams(new LinearLayout.LayoutParams(mWidth, LayoutParams.WRAP_CONTENT));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setActiveColor(@ColorRes int colorRes) {
        SvgUtils.changeSvgColor(getContext(), iv_Tab, colorRes);
        tv_Tab.setTextColor(getResources().getColor(colorRes));
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public int getActiveImageRes() {
        return activeImageRes;
    }

    public void setActiveImageRes(int activeImageRes) {
        this.activeImageRes = activeImageRes;
    }

    public void loadImageRes(int imageRes) {
        iv_Tab.setImageResource(imageRes);
    }
}