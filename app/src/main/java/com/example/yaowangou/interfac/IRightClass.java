package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.RightClass;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public interface IRightClass {
    @GET("rightcalss?")
    Call<RightClass> getRightClass(@Query("parent_id") int parent_id);
}
