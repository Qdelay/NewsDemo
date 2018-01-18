package com.deli.newsdemo.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.deli.newsdemo.R;
import com.deli.newsdemo.util.ScreenUtils;

/**
 * Created by 01369557 on 2018/1/12.
 */

public class BottomNavigation extends LinearLayout {

    private LinearLayout mContainer;

    public BottomNavigation(Context context) {
        this(context, null);
    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View parentView = inflater.inflate(R.layout.bottom_navigation_bar_container, this, true);
        mContainer = parentView.findViewById(R.id.bottom_navigation_bar_container);
        mContainer.addView(new NavigationItem(getContext()));
        mContainer.addView(new NavigationItem(getContext()));
        mContainer.addView(new NavigationItem(getContext()));
        mContainer.addView(new NavigationItem(getContext()));
    }

    private class NavigationItem extends LinearLayout {

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
            itemInflater.inflate(R.layout.bottom_navigation_bar_item, this, true);
        }
    }
}
