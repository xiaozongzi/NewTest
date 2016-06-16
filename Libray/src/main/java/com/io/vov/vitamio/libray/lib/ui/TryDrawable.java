package com.io.vov.vitamio.libray.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.io.vov.vitamio.libray.lib.R;

/**
 * Created by ${zhangzz} on 2016/6/14.
 */
public class TryDrawable  extends RectDrawable{
    private Paint tryPaint;
    private int tryColor;

    public TryDrawable(Context context, int with, int height) {
        super(context, with, height);
        tryPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        tryColor=Color.WHITE;
        tryPaint.setColor(tryColor);
        tryPaint.setTextSize(context.getResources().getDimension(R.dimen.try_text_size));
    }

    public int getTryColor() {
        return tryColor;
    }

    public void setTryColor(int tryColor) {
        this.tryColor = tryColor;
        tryPaint.setColor(tryColor);
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawLiftText(canvas);
    }

    private void drawLiftText(Canvas canvas) {
        tryPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("试",0,getY(),tryPaint);
    }
    private float getY(){
        Paint.FontMetrics fontMetrics=tryPaint.getFontMetrics();
        return (- fontMetrics.top) ;
    }

    @Override
    public void unCheckChange() {
        super.unCheckChange();
        tryPaint.setColor(tryColor);
    }

    @Override
    public void checkedChange() {
        super.checkedChange();
        tryPaint.setColor(Color.WHITE);
    }
}
