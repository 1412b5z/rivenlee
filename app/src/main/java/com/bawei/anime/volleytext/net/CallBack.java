package com.bawei.anime.volleytext.net;

/**
 * Created by Administrator on 2016/12/6 0006.
 */

public interface CallBack {
    //构建一个接口,写俩个方法,一个是请求成功.一个是请求失败
    //将请求成功的数据放入方法中
    void success(String json);
    void fail();
}
