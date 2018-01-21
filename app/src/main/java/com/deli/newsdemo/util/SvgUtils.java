package com.deli.newsdemo.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

/**
 * Created by qiudeli on 2018/1/21.
 * <p>
 * SVG帮助类
 */

public class SvgUtils {

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void changeSvgColor(Context context, ImageView imageView, @ColorRes int ColorRes) {
        VectorDrawable drawable = (VectorDrawable) (imageView.getDrawable());
// must mutate
        drawable.mutate();
        drawable.setTint(ContextCompat.getColor(context, ColorRes));
    }
}
