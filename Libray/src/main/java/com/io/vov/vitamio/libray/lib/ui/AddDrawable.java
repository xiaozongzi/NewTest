package com.io.vov.vitamio.libray.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/**
 * Created by ${zhangzz} on 2016/5/30.
 */
public class AddDrawable extends Drawable implements Animatable{
    private Paint paint;
    private int viewWith;
    private int viewHeight;
    private int degress;
    private int step=5;
    private Type type=Type.ADD;
    private Context context;
    public AddDrawable(Context context,int with, int height) {
        this.viewWith = with;
        this.viewHeight = height;
        this.context=context;
        this.paint=new Paint();
        paint.setAntiAlias(true);


    }

    public Type getType() {
        return type;
    }

    public int getDegress() {
        return degress;
    }

    public void setType(Type type) {
        this.type = type;
        degress=0;
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setColor(context.getResources().getColor(android.R.color.holo_green_dark));
        canvas.drawCircle(viewWith/2,viewHeight/2,viewWith/2,paint);
        paint.setColor(context.getResources().getColor(android.R.color.white));
        if (degress < 90)
            degress += step;
        else {

        }
        drawFirstLine(canvas);
        drawSecondLine(canvas);
    }
    private void drawSecondLine(Canvas canvas) { //画横线
        canvas.save();
        float startX = 0;
        float startY = viewHeight / 2;
        float endX = viewWith;
        float endY = startY;
        int apha = 0;
        switch (type) {
            case ADD:
                apha = 255;
                break;
            case SUBTRACTION:
                apha = (int) ((1 - degress / 90) * 255);

                break;
        }

        paint.setAlpha(apha);
        canvas.rotate(degress, viewWith / 2, viewWith / 2);
        canvas.drawLine(startX, startY, endX, endY, paint);
        canvas.restore();
        paint.setAlpha(255);
/*        if (degress < 90)
            invalidateSelf();*/


    }

    private void drawFirstLine(Canvas canvas) {
        canvas.save();
        float startX =   viewWith / 2;
        float startY = 0;
        float endX = startX;
        float endY = viewHeight;
        int apha = 255;
        switch (type) {
            case ADD:
                apha = (int) (degress / 90 * 255);
                break;
            case SUBTRACTION:
                apha = 255;
                break;
        }
        paint.setAlpha(apha);
        canvas.rotate(degress, viewWith / 2, viewWith / 2);
        canvas.drawLine(startX, startY, endX, endY, paint);
        canvas.restore();
        paint.setAlpha(255);
    }

    public enum Type {
        ADD(1, "add"), SUBTRACTION(2, "subtraction");
        int value;
        String name;

        Type(int value, String name) {
            this.value = value;
            this.name = name;
        }
    }
    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
