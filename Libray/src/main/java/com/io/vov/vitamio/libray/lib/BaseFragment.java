package com.io.vov.vitamio.libray.lib;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

/**
 * Created by ${zhangzz} on 2016/4/7.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        showLog("onAttach");
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        showLog("onCreateAnimation");
        return super.onCreateAnimation(transit, enter, nextAnim);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        showLog("onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showLog("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showLog("onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showLog("onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        showLog("onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        showLog("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        showLog("onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        super.onPause();
        showLog("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        showLog("onStop");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        showLog("onLowMemory");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        showLog("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        showLog("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        showLog("onDetach");
    }

    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
    private void showLog(String msg){
        Log.e("life_fragment", msg);
    }
}
