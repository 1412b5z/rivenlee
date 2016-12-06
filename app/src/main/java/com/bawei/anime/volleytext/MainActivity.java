package com.bawei.anime.volleytext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.anime.volleytext.net.CallBack;
import com.bawei.anime.volleytext.net.httpUtils;

public class MainActivity extends AppCompatActivity {
    private String mData_Url = "http://ic.snssdk.com/2/article/v25/stream/?category=news_tech&count=20&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=1457695555&loc_mode=5&lac=4527&cid=28883&iid=3835029558&device_id=12211880440&ac=wifi&channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&device_type=iToolsAVM&os_api=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用工具类
        httpUtils.getHttpUtils(this).requestGet(mData_Url, new CallBack() {
            //回调方法,此时参数json已经携带请求到的数据了`
            @Override
            public void success(String json) {
                Log.d("TAG",json);
            }

            @Override
            public void fail() {

            }
        });
    }
}
