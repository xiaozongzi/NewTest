package com.io.vov.vitamio.libray.lib.Internet;

import android.util.Log;
import okhttp3.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ${zhangzz} on 2016/2/18.
 * 对okhttp的 {@link OkHttpClient} 的封装
 */
public class HttpUtils  {
    private OkHttpClient okHttpClient;
    private static final int READ_TIME_OUT=15;
    private static HttpUtils httpUtils;


    private HttpUtils( ) {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS).
                connectTimeout(READ_TIME_OUT,TimeUnit.SECONDS).
                writeTimeout(READ_TIME_OUT,TimeUnit.SECONDS);
        okHttpClient=builder.build();

    }
   public static HttpUtils Builder(){
       if (httpUtils==null){
           httpUtils=new HttpUtils();
       }
       return httpUtils;
   }

    /**
     * post 请求
     * @param url
     * @param body
     * @param callback
     */
    public void post(String url, RequestBody body, Callback callback){
        Request request=new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(callback);
        String s="";
        try {
            if (body instanceof FormBody)
            for (int i = 0; i < body.contentLength(); i++) {
                s+= ((FormBody) body).encodedName(i)+ "="+((FormBody) body).encodedValue(i)+"&";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("post",url+"?"+s);
    }

}
