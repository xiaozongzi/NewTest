package com.netease.nim.demo.activity.test;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.netease.nim.demo.R;

public class VideoActivity extends BaseActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoView= (VideoView) findViewById(R.id.video_view);
        videoView.setMediaController(new MediaController(this));

        videoView.setVideoURI(Uri.parse("http://123.59.138.100:8263//Files/0/1107938a7c1144ed905dc3ce31f6d543.flv.mp4"));
        videoView.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
