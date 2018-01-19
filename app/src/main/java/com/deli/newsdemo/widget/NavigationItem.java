package com.deli.newsdemo.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deli.newsdemo.R;
import com.deli.newsdemo.util.ScreenUtils;

/**
 * Created by 01369557 on 2018/1/19.
 */

public class NavigationItem extends LinearLayout {

    private ImageView iv_Tab;
    private TextView tv_Tab;

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
        //ScreenUtils.getScreenWidth();
        setLayoutParams(new LinearLayout.LayoutParams(ScreenUtils.getScreenWidth() / 4, LayoutParams.WRAP_CONTENT));
        LayoutInflater itemInflater = LayoutInflater.from(context);
        View itemView = itemInflater.inflate(R.layout.bottom_navigation_bar_item, this, true);
        iv_Tab = itemView.findViewById(R.id.iv_tab);
        tv_Tab = itemView.findViewById(R.id.tv_tab);
    }
}