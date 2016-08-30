package com.io.vov.vitamio.newtest.app.activity.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.io.vov.vitamio.libray.lib.ui.HorizontalListView;
import com.io.vov.vitamio.newtest.app.R;

import java.util.ArrayList;
import java.util.List;

public class TestListView extends AppCompatActivity {
    private HorizontalListView hListView;
    private List<String>       lsit;
    private TextView goTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_view);


        goTo = (TextView) findViewById(R.id.go_to);
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hListView.setSelection(16);
            }
        });
        hListView = (HorizontalListView) findViewById(R.id.h_list_view);
        hListView.setSelected(true);
        setList();
        hListView.setAdapter(new testAdapter());
    }


    private void setList() {
        lsit=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lsit.add("test"+i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_list_view, menu);
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


    private class testAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return lsit.size();
        }


        @Override
        public Object getItem(int position) {
            return lsit.get(position);
        }


        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView==null){
                holder=new Holder();
                convertView=getLayoutInflater().inflate(R.layout.test_adapter_layout,null);
                holder.textView= (TextView) convertView.findViewById(R.id.name);
                convertView.setTag(holder);
            }else  holder= (Holder) convertView.getTag();
            holder.textView.setText(lsit.get(position));
            return convertView;
        }
        class Holder{
            TextView textView;
        }
    }
}
