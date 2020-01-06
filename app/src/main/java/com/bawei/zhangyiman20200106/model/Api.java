package com.bawei.zhangyiman20200106.model;

import com.bawei.zhangyiman20200106.model.bean.OneBean;
import com.bawei.zhangyiman20200106.model.bean.TwoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 *@auther:张奕漫
 *@Date: 2020/1/6
 *@Time:8:55
 *@Description:
 * */
public interface Api {
    @GET("baweiapi/category")
    Observable<OneBean> oneBean() ;
    @GET("baweiapi/category")
    Observable<TwoBean> twoBean (@Query("category")String category);
}
