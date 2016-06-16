package com.io.vov.vitamio.libray.lib.ui;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.widget.Checkable;
import com.io.vov.vitamio.libray.lib.R;

/**
 * Created by ${zhangzz} on 2016/6/15.
 */
public class RectDrawable extends Drawable implements Checkable {
    private Context context;
    private Paint paint;
    private Paint textPaint;
    private int with,height;
    private boolean checked;
    private int strokColor;
    private int centerTextColor;
    private String text="19";
    public RectDrawable(Context context,int with,int height) {
        this.with=with;
        this.height=height;
        this.context=context;
        paint=new Paint();
        strokColor=Color.RED;

        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokColor);
        paint.setStrokeWidth(context.getResources().getDimension(R.dimen.rect_drawable_stroke_with));
        textPaint=new Paint(Paint.FAKE_BOLD_TEXT_FLAG);
        centerTextColor=Color.WHITE;
        textPaint.setColor(centerTextColor);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(context.getResources().getDimension(R.dimen.center_text_size));
        textPaint.setStrokeWidth(context.getResources().getDimension(R.dimen.rect_drawable_stroke_with));
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStrokColor() {
        return strokColor;
    }

    public void setStrokColor(int strokColor) {
        this.strokColor = strokColor;
        paint.setColor(strokColor);
        invalidateSelf();
    }

    public int getCenterTextColor() {
        return centerTextColor;
    }

    public void setCenterTextColor(int centerTextColor) {
        this.centerTextColor = centerTextColor;
        textPaint.setColor(centerTextColor);
        invalidateSelf();
    }

    @Override
    public void draw(Canvas canvas) {
//        canvas.restore();

//        canvas.save();
        float strokWith=paint.getStrokeWidth();
        RectF rect=new RectF(0+strokWith,0+strokWith,with-strokWith,height-strokWith);

        canvas.drawRoundRect(rect,context.getResources().getDimension(R.dimen.rect_radius),context.getResources().getDimension(R.dimen.rect_radius),paint);
//        canvas.drawRect(0f,0f,with,height,paint);
//        canvas.restore();
        drawCenterText(canvas);

    }


    private void drawCenterText(Canvas canvas) {
        textPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics=textPaint.getFontMetrics();

        canvas.drawText(text,with/2,height/2 + (fontMetrics.descent- fontMetrics.ascent)/2 - fontMetrics.descent,textPaint);
    }


    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        textPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        textPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked=checked;
        if (checked){
            checkedChange();
        }else {
            unCheckChange();
        }
        invalidateSelf();
    }

    public void unCheckChange() {
//        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.STROKE);

    }

    public void checkedChange() {
//        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
    }
}
