package com.deli.newsdemo.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameActivity;
import com.deli.newsdemo.ui.main.MainActivity;

/**
 * Created by qiudeli on 2018/2/8.
 */

public class SplashActivity extends BaseFrameActivity<SplashPresenter, SplashModel> implements SplashContract.View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchToMain();
            }
        }, 1000);

    }

    public void switchToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
