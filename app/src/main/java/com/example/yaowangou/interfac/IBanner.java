package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.Banner;
import com.example.yaowangou.entity.StaticConstant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public interface IBanner {
    @GET("banner")
    Call<Banner> getBanner();
}
