package com.netease.nim.demo.activity;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;

/**
 * Created by ${zhangzz} on 2016/3/1.
 */
public class Video implements MediaPlayer.OnInfoListener,
        MediaPlayer.OnBufferingUpdateListener,MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener {
    private Context context;
    private LittleVideoView videoView;
    private String url;
    private MediaController mediaController;
    private float rate=1.0f;
    private View root;

    public LittleVideoView getVideoView() {
        return videoView;
    }
    public View getRoot(){
        return root;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Video(Context context, String url) {
        this.context = context;
        this.url = url;

        videoView=new LittleVideoView(context);
        RelativeLayout layout=new RelativeLayout(context);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(videoView);
        root=layout;
        init();

    }

    private void init() {
        videoView.requestFocus();
        videoView.setBufferSize(512 * 1024);
       // videoView.setShowDialog(false);
        videoView.setOnInfoListener(this);
        videoView.setOnBufferingUpdateListener(this);
        videoView.setOnCompletionListener(this);
        videoView.setOnPreparedListener(this);
        mediaController=new MediaController(context);
        videoView.setMediaController(mediaController);
        setUrlInVideo();

    }
    private void setUrlInVideo(){
        if (!TextUtils.isEmpty(url)){
            videoView.setVideoURI(Uri.parse(url));
        }
    }
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (videoView.isPlaying()) {
                    Log.e("ceshi", "MEDIA_INFO_BUFFERING_START");
                    videoView.pause();
                    ViewGroup.LayoutParams layoutParams=videoView.getLayoutParams();
              /*      pb.setVisibility(View.VISIBLE);
                    downloadRateView.setText("");
                    loadRateView.setText("");
                    downloadRateView.setVisibility(View.VISIBLE);
                    loadRateView.setVisibility(View.VISIBLE);
*/
                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                Log.e("ceshi", "MEDIA_INFO_BUFFERING_END");
               // videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN,rate);
                videoView.start();
             /*   pb.setVisibility(View.GONE);
                downloadRateView.setVisibility(View.GONE);
                loadRateView.setVisibility(View.GONE);*/
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:


                break;
        }
        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
