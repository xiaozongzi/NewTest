package com.io.vov.vitamio.newtest.app.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by ${zhangzz} on 2016/6/6.
 */
public class InteruptLayout extends RelativeLayout {
    public InteruptLayout(Context context) {
        this(context,null);
    }

    public InteruptLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InteruptLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InteruptLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
    }
    private void send(){
    /*  boolean is=  getChildAt(0).performClick();
        Log.e("send",is?"点击":"没点击");*/
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        getChildAt(0).onTouchEvent(event);
        return super.onTouchEvent(event);
    }


}
