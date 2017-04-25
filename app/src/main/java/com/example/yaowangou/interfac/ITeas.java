package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.Teas;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/4/25/025.
 */

public interface ITeas {
    @GET("teas")
    Call<Teas> getTeas();
}
