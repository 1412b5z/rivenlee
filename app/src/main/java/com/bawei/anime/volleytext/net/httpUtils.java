package com.bawei.anime.volleytext.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/12/6 0006.
 */

public class httpUtils {
    //定义工具类
    private RequestQueue requestQueue;
    //单例模式,避免重复创建对象
    private static httpUtils httpUtils;
    public static httpUtils getHttpUtils(Context context){

        if(httpUtils == null){
            synchronized (httpUtils.class){
                if(httpUtils == null){
                    httpUtils = new httpUtils(context);
                }
            }
        }
        return httpUtils;
    }
    //私有化构造方法
    private httpUtils(Context context){
        requestQueue =  Volley.newRequestQueue(context);
    }
    //获得数据的方法,将需要的URL和携带数据的接口当做参数传递进来
    public void requestGet(String mData_Url, final CallBack callBack){
        //Volley请求网络数据
        StringRequest stringRequest = new StringRequest(mData_Url, new Response.Listener<String>() {
            //成功时调用传递过来接口的成功方法,将数据回调到Activity
            @Override
            public void onResponse(String response) {
                callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.fail();
            }
        });
        requestQueue.add(stringRequest);
    }
}
