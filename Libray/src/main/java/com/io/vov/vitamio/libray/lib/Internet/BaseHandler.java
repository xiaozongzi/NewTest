package com.io.vov.vitamio.libray.lib.Internet;

import android.os.Handler;
import android.os.Message;

/**
 * Created by ${zhangzz} on 2016/2/19.
 * 基本的handler 用于扩充
 */
public class BaseHandler<T,K> extends Handler {
    /**
     * 网络请求类型 上拉刷新和下拉加载跟多等
     */
    private int type;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    private int position;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }

    public K dealData(T t){
        K k=null;
        try {
            k=(K)t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
