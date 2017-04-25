package com.example.yaowangou.interfac;

import com.example.yaowangou.bean.Icon;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/4/22/022.
 */

public interface IIcon {
    @GET("icon")
    Call<Icon> getIcon();
}
