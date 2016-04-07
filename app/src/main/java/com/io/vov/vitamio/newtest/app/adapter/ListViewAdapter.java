package com.io.vov.vitamio.newtest.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.io.vov.vitamio.newtest.app.R;
import com.io.vov.vitamio.newtest.app.bean.ListObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zhangzz} on 2016/4/7.
 */
public class ListViewAdapter extends BaseAdapter {
    private List<ListObject> listObjects;
    private Context context;

    public ListViewAdapter(Context context) {
        this.context = context;
        listObjects=new ArrayList<ListObject>();
    }

    public List<ListObject> getListObjects() {
        return listObjects;

    }

    public void setListObjects(List<ListObject> listObjects) {
        if (listObjects==null)
            listObjects=new ArrayList<ListObject>();
        this.listObjects = listObjects;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return listObjects.get(position);
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
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_view_adapter_layout,null);
            holder.name= (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }holder= (Holder) convertView.getTag();
        ListObject object=listObjects.get(position);
        holder.name.setText(object.getName());
        return convertView;
    }
    class  Holder{
        TextView name;
    }
}
