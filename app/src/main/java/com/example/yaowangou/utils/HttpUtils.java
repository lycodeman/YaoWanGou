package com.example.yaowangou.utils;

import com.example.yaowangou.bean.Top;
import com.example.yaowangou.interfac.IBanner;
import com.example.yaowangou.interfac.IHot;
import com.example.yaowangou.interfac.IIcon;
import com.example.yaowangou.interfac.ITeas;
import com.example.yaowangou.interfac.ITop;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public class HttpUtils {

    public static IBanner retrofitIBanner(String url){
        Retrofit retrofit=new Retrofit.Builder().
                baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(new OkHttpClient()).
                build();
        IBanner iBanner=retrofit.create(IBanner.class);
        return iBanner;
    }

    public static IHot retrofitIHot(String url) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(new OkHttpClient()).
                build();
        IHot iHot = retrofit.create(IHot.class);
        return iHot;
    }

    public static ITop retrofitTop(String url) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(new OkHttpClient()).
                build();
        ITop top = retrofit.create(ITop.class);
        return top;
    }

    public static IIcon retrofitIcon(String url) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(new OkHttpClient()).
                build();
        IIcon iIcon = retrofit.create(IIcon.class);
        return iIcon;
    }

    public static ITeas retrofitTeas(String url) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(new OkHttpClient()).
                build();
        ITeas iTeas = retrofit.create(ITeas.class);
        return iTeas;
    }
}
