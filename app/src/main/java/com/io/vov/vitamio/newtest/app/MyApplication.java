package com.io.vov.vitamio.newtest.app;

import android.app.Application;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.auth.LoginInfo;

/**
 * Created by ${zhangzz} on 2016/9/8.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LoginInfo loginInfo =loginInfo();
//        DemoCache.setContext(this);

        NIMClient.init(this, null, null);
    }
    private LoginInfo loginInfo() {
      /*  String account = "zhangzhongzhi";
        String token = "zhangzhongzhi";

        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(token)) {
            DemoCache.setAccount(account.toLowerCase());
            return new LoginInfo(account, token,"5380f881b6c172834ca1c9d4dc4e4d06");
        } else {
            return null;
        }*/
        return null;
    }
}
