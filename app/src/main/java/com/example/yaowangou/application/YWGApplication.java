package com.example.yaowangou.application;

import android.app.Application;
import android.content.Context;

import com.example.yaowangou.utils.LoggerUtils;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/4/19/019.
 */

public class YWGApplication extends Application {

    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init().methodCount(3);
        LoggerUtils.LOGGER_NO_MESSEGE=1;
        LeakCanary.install(this);
        CONTEXT=getApplicationContext();
    }


}
