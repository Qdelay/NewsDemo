package com.deli.newsdemo.util;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by qiudeli on 2018/2/27.
 */

public class ViewPagerSpeedUtils extends Scroller {


    private int mDuration = 500;

    public ViewPagerSpeedUtils(Context context) {
        super(context);
    }

    public ViewPagerSpeedUtils(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public ViewPagerSpeedUtils(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

}
