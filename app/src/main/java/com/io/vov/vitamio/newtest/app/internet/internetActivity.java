package com.io.vov.vitamio.newtest.app.internet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.io.vov.vitamio.libray.lib.Internet.BaseHandler;
import com.io.vov.vitamio.newtest.app.R;
import okhttp3.FormBody;

/**
 * Created by ${zhangzz} on 2016/5/26.
 */
public class internetActivity extends BaseActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_activity);
        init();
    }

    private void init() {
        imageView= (ImageView) findViewById(R.id.image_view);
        Glide.with(this)
                .load("http://192.168.2.147:8021//Files/0/39c732ce89eb479a98f7f12f29ce8eb6.jpg")
                .fitCenter()
                .crossFade()
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo();

            }
        });
    }
    private void goTo(){
        FormBody.Builder body=new FormBody.Builder();
        body.add("uid",34+"");


        body.add("EuId", "996");
        body.add("userRemainingTime", 3000 + "");
        body.add("answer"," [{\"id\":511,\"content\":[\"Ddx\"]}]");
        body.add("key","lerkjgl5498$3-g4a;dl4o88t6");
        InternetUtils.SubmitExerciseStudentAnswer(new BaseHandler(),body);
    }
}
