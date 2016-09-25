package com.io.vov.vitamio.newtest.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.io.vov.vitamio.libray.lib.BaseFragment;

/**
 * Created by ${zhangzz} on 2016/6/3.
 */
public class TestFragment extends BaseFragment {

    private android.widget.Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, null);
        this.button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("send","点击");
            }
        });
        return view;
    }
}
