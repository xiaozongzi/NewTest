package com.io.vov.vitamio.newtest.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.io.vov.vitamio.libray.lib.BaseActivity;

public class ActivityB extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb);
    }

    public void click(View view) {
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
}
