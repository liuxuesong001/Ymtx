package com.lypt.project.api;

import com.lypt.project.ui.fm.child.model.HomeBean;
import com.lypt.project.ui.home.entity.SysBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/1/16.
 */

public interface YmtApi {


    @GET("/")
    Observable<SysBean> getData(@Query("reg_Id") String regId);
}
