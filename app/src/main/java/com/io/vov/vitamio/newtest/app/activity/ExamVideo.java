package com.io.vov.vitamio.newtest.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.io.vov.vitamio.newtest.app.R;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.utils.Log;

/**
 * Created by ${zhangzz} on 2016/3/1.
 */
public class ExamVideo extends Activity {


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_video);
        Vitamio.isInitialized(getApplicationContext());
        Video video=new Video(this,"http://192.168.2.80:8261/data/1/2015/October/13/retechwing/d6a701b10e9163bf433944503286ac28.mp4.mp4");
        if (video!=null&&video.getRoot()!=null)
        addContentView(video.getRoot(),
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        Log.e("ExamVideo","ExamVideoonCreate");

    }
}
