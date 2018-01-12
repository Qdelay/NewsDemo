package com.deli.newsdemo.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.deli.newsdemo.R;

/**
 * Created by 01369557 on 2018/1/12.
 */

public class BottomNavigation extends FrameLayout {

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
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View parentView = inflater.inflate(R.layout.bottom_navigation_bar_container, this, true);
        mContainer = parentView.findViewById(R.id.bottom_navigation_bar_container);
        mContainer.addView(new NavigationItem(getContext()));
    }

    private class NavigationItem extends FrameLayout {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        public NavigationItem(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public NavigationItem(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        public NavigationItem(Context context) {
            this(context, null);
        }
    }
}
