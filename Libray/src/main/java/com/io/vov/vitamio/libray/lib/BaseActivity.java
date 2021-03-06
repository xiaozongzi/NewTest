package com.io.vov.vitamio.libray.lib;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLog("onCreate");
        startScreenBroadcastReceiver();
        PadOrPhone();
    }
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        showLog("onStop");
        super.onStop();
      /*  if (isAppOnForeground()){
            showToast("app foreground");
            Log.e("onStop","app  foreground");
        }else {
            showToast("app not foreground");
            Log.e("onStop","app not foreground");
        }*/
    }

    /**
     * 为true，表示有两种状态：a、屏幕是黑的 b、目前正处于解锁状态 。
     为false，表示目前未锁屏
        还可以通过广播来实现 {@value  mScreenReceiver}
     * @return
     */
    KeyguardManager mKeyguardManager;
    private boolean isScreenOff(){
        if (mKeyguardManager==null)
         mKeyguardManager = (KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
        return  mKeyguardManager.inKeyguardRestrictedInputMode();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction()==event.KEYCODE_HOME){
            Log.e("onStop","home press"); //home 无法监听
        }
        return super.onKeyDown(keyCode, event);

    }

    private ScreenBroadcastReceiver mScreenReceiver;
    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;


        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) {
                // 开屏
                Log.e("onStop"," 开屏");
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                // 锁屏
                Log.e("onStop","锁屏");
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
                // 解锁
                Log.e("onStop","解锁 ");
            }
        }
    }
    private void startScreenBroadcastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        mScreenReceiver=new ScreenBroadcastReceiver();
        registerReceiver(mScreenReceiver, filter);
    }
    /**
     * 判断app是否 正在显示 推荐使用这种方式
     * @return
     */
    public boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the
        // device

        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null)
            return false;

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy");
    }


    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume"+toString());
    }


    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        showLog("onRestart");
    }


    /**
     * 需要权限:android.permission.GET_TASKS
     *不能完全实现 app的状态变化监听，只有通过home 才能判断app不显示，通过drawer切换 不能正确的 判断
     * @param context
     * @return
     */
    public boolean isAppOnForeground(Context context) {
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (tasks != null && !tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            ActivityManager.RunningTaskInfo info=tasks.get(0);

            Log.e("", "topActivity:" + topActivity.flattenToString());
            Log.e("", "topActivity:" + topActivity.flattenToString());
            if (topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
    private void  PadOrPhone(){
        Log.e("PadOrPhone",isPad()?"pad":"phone");
    }
    private boolean isPad() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        // 屏幕宽度
        float screenWidth = display.getWidth();
        // 屏幕高度
        float screenHeight = display.getHeight();
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
        // 屏幕尺寸
        double screenInches = Math.sqrt(x + y);
        // 大于6尺寸则为Pad
        if (screenInches >= 6.0) {
            return true;
        }
        return false;
    }
    private void showLog(String msg){
        Log.e("life_activity",msg);
    }
}
