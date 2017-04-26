package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.LeftClass;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public interface ILeftClass {
    @GET("leftclass")
    Call<LeftClass> getLeftClass();
}
