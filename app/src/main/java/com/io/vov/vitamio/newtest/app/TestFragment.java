package com.io.vov.vitamio.newtest.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.io.vov.vitamio.libray.lib.BaseFragment;

/**
 * Created by ${zhangzz} on 2016/6/3.
 */
public class TestFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.test_fragment,null);
        return view;
    }
}
