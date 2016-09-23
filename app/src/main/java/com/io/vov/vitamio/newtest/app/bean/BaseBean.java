package com.netease.nim.demo.bean;

import java.io.Serializable;

/**
 * Created by ${zhangzz} on 2016/5/17.
 */
public class BaseBean implements Serializable {
    private int id=hashCode();  /*解决 向activity传参 传递同一个对象 需要比对是否一样时使用*/
    public BaseBean() {
    }



    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
