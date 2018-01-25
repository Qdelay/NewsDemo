package com.deli.newsdemo.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.deli.newsdemo.R;

/**
 * Created by 01369557 on 2018/1/25.
 * 顶部Banner
 */

public class HeadBanner extends RelativeLayout {
    public HeadBanner(Context context) {
        this(context, null);
    }

    public HeadBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public HeadBanner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.head_banner, this, true);
    }
}
