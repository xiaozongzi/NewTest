package com.io.vov.vitamio.libray.lib.ui;

import android.graphics.*;
import android.graphics.drawable.Drawable;

/**
 * Created by ${zhangzz} on 2016/6/15.
 */
public class RectTestDrawable extends Drawable {
    Paint paint;

    public RectTestDrawable() {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF=new RectF(0,0,60,40);
        canvas.drawRoundRect(rectF,16,16,paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
