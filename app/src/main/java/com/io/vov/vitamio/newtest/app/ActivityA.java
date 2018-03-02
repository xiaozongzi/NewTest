package com.io.vov.vitamio.newtest.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.io.vov.vitamio.libray.lib.BaseActivity;


public class ActivityA extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aa);
        if (savedInstanceState != null) {
            Log.e("onSaveInstanceState", "not null");

        }
        initView();
    }

    public void click(View view) {
        Intent intent = new Intent(this, ActivityB.class);

        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e("onSaveInstanceState", "0000");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("dfa", "dfdf");
        Log.e("onSaveInstanceState", "dfadfas");
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.text_view);
   /*     textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false; //返回true时 点击事件不会执行，返回false了才会
            }
        });*/
    }
}
