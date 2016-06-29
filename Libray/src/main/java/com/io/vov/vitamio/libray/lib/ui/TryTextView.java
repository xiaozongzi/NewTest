package com.io.vov.vitamio.libray.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.io.vov.vitamio.libray.lib.R;

/**
 * Created by ${zhangzz} on 2016/6/15.
 */
public class TryTextView extends View implements Checkable {
    TryDrawable drawable;
    RectTestDrawable rectTestDrawable;
    private PartDrawable partDrawable;
    boolean checked;
    public TryTextView(Context context) {
        this(context,null);
    }

    public TryTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TryTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        drawable=new TryDrawable(getContext(),getMeasuredWidth(),getMeasuredHeight());
        drawable.setTryColor(getResources().getColor(R.color.try_color));
//        drawable.setStrokColor(getResources().getColor(R.color.try_color));
        drawable.setCallback(this);
//        setCompoundDrawables(null,null,null,drawable);
       /* setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
                invalidate();
            }
        });*/
        rectTestDrawable=new RectTestDrawable();
        partDrawable=new PartDrawable(getMeasuredWidth(),getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawable.draw(canvas);
//        rectTestDrawable.draw(canvas);
            partDrawable.draw(canvas);
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked=checked;
        drawable.setChecked(checked);
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
