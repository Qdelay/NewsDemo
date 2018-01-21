package com.deli.newsdemo.widget.navigation;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.deli.newsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 01369557 on 2018/1/12.
 *
 * 建造者模式自定义option
 */

public class BottomNavigation extends LinearLayout {

    private LinearLayout mContainer;

    private onClickListener mOnClickListener;

    private int activeColor;

    private NavigationItem oldClickItem;

    private List<BottomNavigationBean> mNavigationItems = new ArrayList<>();

    private List<NavigationItem> tabItem = new ArrayList<>();


    private int postion = 0;

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
    }

    public BottomNavigation addItem(BottomNavigationBean navigationBean) {
        mNavigationItems.add(navigationBean);
        return this;
    }

    public BottomNavigation setActiveColor(@ColorRes int colorRes) {
        this.activeColor = colorRes;
        return this;
    }

    public void initilize() {
        int width = BottomNavigationHelper.calculateWidth(mNavigationItems.size());
        for (final BottomNavigationBean bottomNavigationBean : mNavigationItems) {
            final NavigationItem navigationItem = new NavigationItem(getContext());
            navigationItem.setOnClickListener(new OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View view) {
                    mOnClickListener.onClick(mNavigationItems.indexOf(bottomNavigationBean));
                    colorExchange(navigationItem);
                }
            });
            tabItem.add(navigationItem);
            navigationItem.setWidth(width);
            BottomNavigationHelper.dataBinding(navigationItem, bottomNavigationBean);
            navigationItem.loadImageRes(navigationItem.getImageRes());
            mContainer.addView(navigationItem);
        }
        tabItem.get(postion).callOnClick();
    }

    public BottomNavigation setPosition(int position) {
        this.postion = position;
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void colorExchange(NavigationItem newItem) {
        if (oldClickItem == newItem)
            return;
        newItem.loadImageRes(newItem.getActiveImageRes());
        newItem.setActiveColor(activeColor);
        if (oldClickItem != null) {
            oldClickItem.setActiveColor(R.color.colorAccent);
            oldClickItem.loadImageRes(oldClickItem.getImageRes());
        }
        oldClickItem = newItem;
    }


    public void setItemClickListener(onClickListener itemClickListener) {
        this.mOnClickListener = itemClickListener;
    }

    public interface onClickListener {
        void onClick(int position);
    }
}
