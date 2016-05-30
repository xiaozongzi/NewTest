package com.io.vov.vitamio.libray.lib.Internet;

import android.os.Message;
import android.text.TextUtils;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by ${zhangzz} on 2016/2/18.
 * 网络请求的抽象类
 */
public abstract class Internet {
    public static String BASE_URL="http://192.168.2.131/zh-CN/Mobile/Mobile/";
//    public static String BASE_URL="http://v3m.demo.elearningcn.com/zh-CN/Mobile/Mobile/";
    public static final int SUCCESS=1;
    public static final int FAILED =0;


    /**
     *
     * @param mothed 接口名字
     * @param body  参数
     * @param toJson 转json数据的接口
     * @param handler   用于获取完整数据之后的 通知 必须继承{@link BaseHandler}
     */

    public static void post(String mothed, FormBody.Builder  body, final StringToJson toJson,
                            final BaseHandler handler){
        if (!checkInternet()){
            sendMessge(handler, FAILED,"");
            return;
        }
        String url=BASE_URL+mothed;
        body= addParams(body);
         HttpUtils.Builder().post(url, body.build(), new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 sendMessge(handler, FAILED,e.getMessage());
             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 String result=response.body().string();
                    Object o;
                    if (toJson!=null){
                        try {
                           o= toJson.toJson(result);

                            if(null != o)
                            {
                                sendMessge(handler,SUCCESS,handler.dealData(o));
                            }
                           else
                            {
                                sendMessge(handler, FAILED,"");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            sendMessge(handler, FAILED,e.getMessage());

                        }
                    }
             }
         });
    }
    public static void post(String mothed, FormBody.Builder  body, final StringToJson toJson,
                            final BaseHandler handler,boolean isCache){
        //cache


        post(mothed,body,toJson,handler);
    }
    public static boolean checkInternet(){
        return true;
    }
    public static void postArray(String mothed, RequestBody body, final StringToJson toJson, final BaseHandler handler){
        String url=BASE_URL+mothed;
        HttpUtils.Builder().post(url, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendMessge(handler, FAILED,e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                if (!TextUtils.isEmpty(result)){
                    Object o;
                    if (toJson!=null){
                        try {
                            JSONArray array =   new JSONArray(result);
                            if(null != array && array.length()>0)
                            {
                                sendMessge(handler,SUCCESS,array.get(0));
                            }
                           else
                            {
                                sendMessge(handler, FAILED,"");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            sendMessge(handler, FAILED,e.getMessage());

                        }
                    }
                }
            }
        });
    }
    /**
     * 统一操作参数
     * @param body
     * @return
     */
    private static FormBody.Builder addParams(FormBody.Builder body){
        if (body!=null){
            body.add("key","lerkjgl5498$3-g4a;dl4o88t6");
        }
        return body;
    }
    /**
     *
     * @param handler
     * @param wat
     * @param o 获取到数据的最终object
     */
    private static void sendMessge(BaseHandler handler,int wat,Object o){
        if (handler!=null){
            Message message=new Message();
            message.what=wat;
            message.obj=o;
            handler.sendMessage(message);
        }
    }
public interface StringToJson <T>{
    public T toJson(String jsonString)  throws JSONException;
}
}
