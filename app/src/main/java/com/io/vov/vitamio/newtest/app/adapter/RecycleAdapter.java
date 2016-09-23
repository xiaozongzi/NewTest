package com.netease.nim.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netease.nim.demo.R;

import java.util.List;

/**
 * Created by ${zhangzz} on 2016/8/15.
 */
public class RecycleAdapter extends RecyclerView.Adapter {
    List<String> list;
    Context context;


    public RecycleAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(R.layout.desgin_layout,null);

        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.textView.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder{
        private TextView textView;

        public Holder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text_view);

        }
    }
}
