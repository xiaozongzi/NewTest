package com.io.vov.vitamio.newtest.app.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import io.vov.vitamio.utils.ScreenResolution;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by ${zhangzz} on 2016/3/2.
 */
public class LittleVideoView extends VideoView {
    private int defultWidth,defultHeight;
    public LittleVideoView(Context context) {
        super(context);
        setVideoDefulteSize();
    }

    public LittleVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVideoDefulteSize();
    }

    public LittleVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setVideoDefulteSize();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(defultWidth, defultHeight);
    }
    public int getDefultWidth() {
        return defultWidth;
    }

    public int getDefultHeight() {
        return defultHeight;
    }


    /**
     * 获取设备的大小
     */
    private void setVideoDefulteSize(){
        Pair<Integer, Integer> res = ScreenResolution.getResolution(mContext);
        int windowWidth = res.first.intValue(), windowHeight = res.second.intValue();
        defultWidth=windowWidth;
        defultHeight=defultWidth*windowWidth/windowHeight;
    }

}
