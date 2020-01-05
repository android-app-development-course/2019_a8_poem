package com.example.parentingbook.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.parentingbook.MainActivity;
import com.example.parentingbook.R;

public class SplashActivity extends Activity {

    //欢迎页
    //页面停留时长3s
    private static final long DELAY_TIME=3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //无title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
        setContentView(R.layout.activity_splash);

        //延时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                //结束当前Activity
                finish();
            }
        }, DELAY_TIME);
    }
}
