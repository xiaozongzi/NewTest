package com.io.vov.vitamio.libray.lib;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by ${zhangzz} on 2016/4/7.
 */
public class BaseFragment extends Fragment {
    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
