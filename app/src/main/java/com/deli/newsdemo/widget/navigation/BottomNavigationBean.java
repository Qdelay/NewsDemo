package com.deli.newsdemo.widget.navigation;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * Created by qiudeli on 2018/1/20.
 * <p>
 * 传递给navigationItem的资源
 */

public class BottomNavigationBean {
    private int iconRes;
    private int itemTitle;
    private int activeRes;

    public BottomNavigationBean setIconRes(@DrawableRes int iconRes) {
        this.iconRes = iconRes;
        return this;
    }

    public BottomNavigationBean setItemTitle(@StringRes int itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    public BottomNavigationBean setActiveRes(int activeRes) {
        this.activeRes = activeRes;
        return this;
    }

    public int getIconRes() {
        return iconRes;
    }

    public int getItemTitle() {
        return itemTitle;
    }

    public int getActiveRes() {
        return activeRes;
    }

}
