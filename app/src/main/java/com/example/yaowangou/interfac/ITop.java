package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.Top;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public interface ITop {
    @GET("top")
    Call<Top> getTop();
}
