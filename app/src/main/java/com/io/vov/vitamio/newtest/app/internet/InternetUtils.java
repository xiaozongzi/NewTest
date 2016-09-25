package com.io.vov.vitamio.newtest.app.internet;


import com.io.vov.vitamio.libray.lib.Internet.BaseHandler;
import com.io.vov.vitamio.libray.lib.Internet.Internet;
import okhttp3.FormBody;

/**
 * Created by ${zhangzz} on 2016/2/19.
 */
public class InternetUtils extends Internet {
    static {
//        BASE_URL = "http://192.168.2.131/zh-CN/Mobile/Mobile/";
//        BASE_URL="http://v3m.demo.elearningcn.com/zh-CN/Mobile/Mobile/";
    }
    public static void SubmitExerciseStudentAnswer(BaseHandler handler, FormBody.Builder body) {
        post(Mothed.SubmitStudentAnswer.getName(), body, null, handler);
    }



}