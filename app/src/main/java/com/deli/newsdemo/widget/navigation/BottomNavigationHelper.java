package com.deli.newsdemo.widget.navigation;

import com.deli.newsdemo.util.ScreenUtils;

/**
 * Created by qiudeli on 2018/1/20.
 * <p>
 * navigation帮助类
 */

public class BottomNavigationHelper {
    public static void dataBinding(NavigationItem navigationItem, BottomNavigationBean bottomNavigationBean) {
        navigationItem.setImageRes(bottomNavigationBean.getIconRes());
        navigationItem.setTitle(bottomNavigationBean.getItemTitle());
        if (bottomNavigationBean.getActiveRes() == 0) {
            navigationItem.setActiveImageRes(bottomNavigationBean.getIconRes());
        } else {
            navigationItem.setActiveImageRes(bottomNavigationBean.getActiveRes());
        }
    }

    public static int calculateWidth(int size) {
        return ScreenUtils.getScreenWidth() / size;
    }
}
