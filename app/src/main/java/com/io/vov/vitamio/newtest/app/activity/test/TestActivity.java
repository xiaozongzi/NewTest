package com.io.vov.vitamio.newtest.app.activity.test;

import android.os.Bundle;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.io.vov.vitamio.newtest.app.R;
import com.io.vov.vitamio.newtest.app.bean.BaseBean;
import io.vov.vitamio.utils.Log;

/**
 * Created by ${zhangzz} on 2016/5/17.
 */
public class TestActivity extends BaseActivity {
    private BaseBean object,secondObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);
        getIntentData();
    }

    private void getIntentData() {
        object= (BaseBean) getIntent().getSerializableExtra("object");
        secondObject= (BaseBean) getIntent().getSerializableExtra("secondObject");
        if (object.equals(secondObject)){
            Log.e("object","===");
        }
        Log.e("object",object.hashCode()+"/"+secondObject.hashCode());
    }
}
