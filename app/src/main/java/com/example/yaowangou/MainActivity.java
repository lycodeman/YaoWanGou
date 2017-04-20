package com.example.yaowangou;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yaowangou.activity.YaoWanGouActivity;
import com.example.yaowangou.utils.ActivityUtils;
import com.example.yaowangou.utils.LoggerUtils;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoggerUtils.D("初步测试");
        StatusBarUtil.setTransparent(this);
        ActivityUtils.toastShortMessege("正在加载...");
        new Thread(()->{
            SystemClock.sleep(3000);
            startActivity(new Intent(this, YaoWanGouActivity.class));
            finish();
        }).start();


    }
}
