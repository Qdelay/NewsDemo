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

    public BottomNavigationBean(@DrawableRes int iconRes, @StringRes int itemTitle) {
        this.iconRes = iconRes;
        this.activeRes = iconRes;
        this.itemTitle = itemTitle;
    }

    public BottomNavigationBean(@DrawableRes int iconRes, @DrawableRes int activeRes, @StringRes int itemTitle) {
        this.iconRes = iconRes;
        this.activeRes = activeRes;
        this.itemTitle = itemTitle;
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
