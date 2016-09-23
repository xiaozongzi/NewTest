package com.netease.nim.demo.activity.test;

import android.os.Bundle;
import android.widget.CheckBox;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.netease.nim.demo.R;
import com.netease.nim.demo.bean.BaseBean;
import io.vov.vitamio.utils.Log;

/**
 * Created by ${zhangzz} on 2016/5/17.
 */
public class TestActivity extends BaseActivity {
    private BaseBean object,secondObject;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_layout);
        getIntentData();
        checkBox= (CheckBox) findViewById(R.id.checkbox);
//        checkBox.setButtonDrawable(new TryDrawable());
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
