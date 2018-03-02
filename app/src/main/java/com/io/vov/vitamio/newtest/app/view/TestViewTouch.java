package com.io.vov.vitamio.newtest.app.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class TestViewTouch extends TextView {
    public TestViewTouch(Context context) {
        super(context);
    }

    public TestViewTouch(Context context,
                         @Nullable
                                 AttributeSet attrs) {
        super(context, attrs);
    }

    public TestViewTouch(Context context,
                         @Nullable
                                 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
        //直接返回true时不会响应点击时间，
        // 如果调用super.onTouchEvent再返回true还是会响应点击事件，
        //返回false也不会响应点击时间

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }
}
