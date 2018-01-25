package com.deli.newsdemo.util;

import android.content.Context;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * Created by qiudeli on 2018/1/21.
 *
 * SVG帮助类
 */

public final class SvgUtils {

    public static void changeSvgColor(Context context, ImageView imageView, @ColorRes int ColorRes) {
        VectorDrawable drawable = (VectorDrawable) (imageView.getDrawable());
        drawable.mutate();
        drawable.setTint(ContextCompat.getColor(context, ColorRes));
    }
}
