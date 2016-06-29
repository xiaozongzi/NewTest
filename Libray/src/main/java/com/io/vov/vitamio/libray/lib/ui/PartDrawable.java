package com.io.vov.vitamio.libray.lib.ui;

import android.graphics.*;
import android.graphics.drawable.Drawable;

/**
 * Created by ${zhangzz} on 2016/6/21.
 * 标签drawable
 */
public class PartDrawable extends Drawable {
    private Paint liftPaint;
    private Paint liftTextPaint;
    private Paint rightPaint;
    private Paint rightTextPaint;
    private int with,height;
    private int liftWith,liftHeight,rightWith,rightHeight;
    private final int dump=10;
    private int radiusDump=5;
    private int degree=150;

    PointF liftArcLiftAndTopPoint,liftArcRightAndBottomPoint,liftRectTopPoint,liftRectBottomPoint,
            liftRightArcTopPoint,liftRightArcBottomPoint;
    public PartDrawable(int with,int height) {
        this.with=with;
        this.height=height;
        liftWith=with*2/3;
        rightWith=with-liftWith;
        liftHeight=height-dump;

        liftPaint = new Paint();
        liftPaint.setAntiAlias(true);
        initLiftPaint();

        liftTextPaint = new Paint();
        liftTextPaint.setAntiAlias(true);
        liftTextPaint.setColor(Color.WHITE);
        liftTextPaint.setStyle(Paint.Style.STROKE);
        liftTextPaint.setTextAlign(Paint.Align.CENTER);

        rightPaint = new Paint();
        rightPaint.setAntiAlias(true);
        rightPaint.setColor(Color.RED);
        rightPaint.setStyle(Paint.Style.STROKE);


        rightTextPaint = new Paint();
        rightTextPaint.setAntiAlias(true);
        rightTextPaint.setColor(Color.RED);
        rightTextPaint.setStyle(Paint.Style.STROKE);
        calPoint();

    }

    private void initLiftPaint() {
        liftPaint.setColor(Color.GRAY);
        liftPaint.setStyle(Paint.Style.FILL);
    }

    private void calPoint() {
        liftArcLiftAndTopPoint=new PointF() ;
        liftArcRightAndBottomPoint=new PointF();
                liftRectTopPoint=new PointF();
                liftRectBottomPoint=new PointF();
                liftRightArcTopPoint=new PointF();
                liftRightArcBottomPoint=new PointF();

        liftArcLiftAndTopPoint.x=dump/2;
        liftArcLiftAndTopPoint.y=dump/2;
        liftArcRightAndBottomPoint.x=liftHeight+ liftArcLiftAndTopPoint.x;
        liftArcRightAndBottomPoint.y=liftHeight+ liftArcLiftAndTopPoint.y;

        liftRectTopPoint.x=Double.valueOf (liftHeight/2+dump/2 - Math.cos(2 * Math.PI / 360 * (degree/2)) * liftHeight/2).floatValue();
        liftRectTopPoint.y= Double.valueOf ((liftHeight - Math.sin(2 * Math.PI / 360 * (degree/2)) * liftHeight) / 2+dump/2).floatValue();
        liftRectBottomPoint.x=liftWith;
        liftRectBottomPoint.y=liftRectTopPoint.y+ Double.valueOf(Math.sin(2 * Math.PI / 360 * (degree/2)) * liftHeight).floatValue();

        liftRightArcTopPoint.x=liftRectBottomPoint.x
                -Double.valueOf((liftHeight/2 - Math.cos(2 * Math.PI / 360 * (degree/2)) * liftHeight/2)).floatValue()+radiusDump;
        liftRightArcTopPoint.y=liftArcLiftAndTopPoint.y-radiusDump;
        liftRightArcBottomPoint.x=liftRightArcTopPoint.x+liftHeight+radiusDump*2;
        liftRightArcBottomPoint.y=liftRightArcTopPoint.y+liftHeight+radiusDump*2;

    }

    @Override
    public void draw(Canvas canvas) {
        drawLift(canvas);
        drawRight(canvas);

    }

    private void drawLift(Canvas canvas) {
        initLiftPaint();
//        canvas.save();
        RectF rectF=new RectF(liftArcLiftAndTopPoint.x,liftArcLiftAndTopPoint.y,liftArcRightAndBottomPoint.x,liftArcRightAndBottomPoint.y);
        canvas.drawArc(rectF,
                180-degree/2,degree,false
                , liftPaint);
     /*   Path path=new Path();
        path.addArc(liftArcLiftAndTopPoint.x,liftArcLiftAndTopPoint.y,liftArcRightAndBottomPoint.x,liftArcRightAndBottomPoint.y,
                180-degree/2,degree);
      */
        RectF rectF2=new RectF(liftRectTopPoint.x,liftRectTopPoint.y,liftRectBottomPoint.x,liftRectBottomPoint.y);
        canvas.drawRect(rectF2,liftPaint);

        liftPaint.setStyle(Paint.Style.FILL);
        liftPaint.setColor(Color.WHITE);
        float realDegree=Double.valueOf(Math.toDegrees(Math.asin( Double.valueOf(Math.sin(2 * Math.PI / 360 * (degree/2)) * liftHeight/2/(liftHeight/2+radiusDump))))*2).floatValue();
      RectF rectF1=new RectF(liftRightArcTopPoint.x,liftRightArcTopPoint.y,liftRightArcBottomPoint.x,liftRightArcBottomPoint.y);
        canvas.drawArc(rectF1,
                180-degree/2+(degree- realDegree)/2,
                realDegree,false,liftPaint);
        drawLiftText(canvas);
//        canvas.restore();
    }

    private void drawLiftText(Canvas canvas) {
        canvas.drawText("Part",liftWith/2,height/2,liftTextPaint);
    }

    private void drawRight(Canvas canvas) {
        PointF rightCirclePoint=new PointF();
        PointF rightCircleBottom=new PointF();
        rightCirclePoint.x= liftRightArcTopPoint.x+radiusDump;
        rightCirclePoint.y=liftRightArcTopPoint.y+radiusDump;
        rightCircleBottom.x=rightCirclePoint.x+liftHeight;
        rightCircleBottom.y=rightCirclePoint.y+liftHeight;
        RectF rectF=new RectF(rightCirclePoint.x,rightCirclePoint.y,rightCircleBottom.x,rightCircleBottom.y);
        canvas.drawArc(rectF,
                0,360,false
        ,rightPaint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        liftPaint.setColorFilter(colorFilter);
        liftTextPaint.setColorFilter(colorFilter);
        rightPaint.setColorFilter(colorFilter);
        rightTextPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
