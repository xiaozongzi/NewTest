package com.io.vov.vitamio.newtest.app.activity.test;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.io.vov.vitamio.newtest.app.R;
import com.io.vov.vitamio.newtest.app.adapter.RecycleAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ${zhangzz} on 2016/8/2.
 */
public class TestDesgin extends BaseActivity {
    RecyclerView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_design);
        init();
    }


    private void init() {
        listView= (RecyclerView) findViewById(R.id.list_view);
        listView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(new RecycleAdapter(getStringList(),this));
    }


    private List<String> getStringList() {
        String []s=new String[]{
                "22",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",   "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
                "11111",
        };

        return Arrays.asList(s);
    }
}
