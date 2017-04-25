package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.Hot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/4/20/020.
 */

public interface IHot {
    /*HTTP_HOT="hot?offset=0&pagesize=6";*/
    @GET("hot")
    Call<Hot> getHot(@Query("offset")int offset,@Query("pagesize")int pagesize );
}
