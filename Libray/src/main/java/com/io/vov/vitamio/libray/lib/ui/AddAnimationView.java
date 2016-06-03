package com.io.vov.vitamio.libray.lib.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by ${zhangzz} on 2016/5/27.
 */
public class AddAnimationView extends BaseView {
    private Paint addPaint;
    private boolean isAnimation;
    private int addColor;
    private int backColor;
    private int viewWith;
    private int viewHeight;
    private Type type;

    public AddAnimationView(Context context) {
        this(context, null);
    }

    public AddAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addColor = getContext().getResources().getColor(android.R.color.holo_blue_bright);
        backColor = getContext().getResources().getColor(android.R.color.white);
        setBackgroundColor(backColor);
        addPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        addPaint.setColor(addColor);
        addPaint.setStyle(Paint.Style.STROKE);
        addPaint.setStrokeWidth(dpToPx(getResources(), 2));
        type = Type.ADD;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
          /*      type = type == Type.ADD ? Type.SUBTRACTION : Type.ADD;
                degress = 0;*/
                drawable.setType((drawable.getType()== AddDrawable.Type.ADD) ? AddDrawable.Type.SUBTRACTION: AddDrawable.Type.ADD);
                invalidate();
            }
        });
    }

    static float dpToPx(Resources resources, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AddAnimationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        viewWith = getMeasuredWidth();
        viewHeight = getMeasuredHeight();
        drawable=new AddDrawable(getContext(),viewWith,viewHeight);
        drawable.setCallback(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    private AddDrawable drawable;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawItem(canvas);

            drawable.draw(canvas);

    }

    private void drawItem(Canvas canvas) {
        if (degress < 90)
            degress += step;
        else {

        }
        drawFirstLine(canvas);
        drawSecondLine(canvas);
    }

    private final int step = 5;
    private float degress = 0;

    private void drawSecondLine(Canvas canvas) { //画横线
        canvas.save();
        float startX = getPaddingLeft();
        float startY = getPaddingTop() + viewHeight / 2;
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

        addPaint.setAlpha(apha);
        canvas.rotate(degress, viewWith / 2, viewWith / 2);
        canvas.drawLine(startX, startY, endX, endY, addPaint);
        canvas.restore();
        addPaint.setAlpha(255);
        if (degress < 90)
            postInvalidate();


    }

    private void drawFirstLine(Canvas canvas) {
        canvas.save();
        float startX = getPaddingLeft() + viewWith / 2;
        float startY = getPaddingTop();
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
        addPaint.setAlpha(apha);
        canvas.rotate(degress, viewWith / 2, viewWith / 2);
        canvas.drawLine(startX, startY, endX, endY, addPaint);
        canvas.restore();
        addPaint.setAlpha(255);
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
}

