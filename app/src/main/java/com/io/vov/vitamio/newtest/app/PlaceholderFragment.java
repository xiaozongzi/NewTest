package com.io.vov.vitamio.newtest.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.io.vov.vitamio.libray.lib.BaseFragment;
import com.io.vov.vitamio.newtest.app.activity.test.*;
import com.io.vov.vitamio.newtest.app.adapter.ListViewAdapter;
import com.io.vov.vitamio.newtest.app.bean.ListObject;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zhangzz} on 2016/4/7.
 */
public class PlaceholderFragment extends BaseFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG                = "PlaceholderFragment";
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private ListView listView;
    private ListViewAdapter  adapter;
    private List<ListObject> listObjects;


    public PlaceholderFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle              args     = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        init(rootView);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getList();
        adapter.setListObjects(listObjects);
        listView.setItemChecked(5, true);
        listView.setItemsCanFocus(false);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showToast("点击"+position);
//                Intent intent=new Intent(getActivity(), ChartsActivity.class);
//                gotoTest(position);
         /*       Intent intent=new Intent(getActivity(), internetActivity.class);
                startActivity(intent);*/
                gotoTest(position);
            }
        });
    }


    private void gotoTest(int position) {
        Intent intent = new Intent();
        switch (position) {

            case 0:
                intent.setClass(getContext(), TestActivity.class);
                intent.putExtra("object", listObjects.get(position));
                intent.putExtra("secondObject", listObjects.get(position));
                break;
            case 1:
                intent.setClass(getContext(), TestDesgin.class);
                break;
            case 2:
                intent.setClass(getContext(), VideoActivity.class);
                break;
            case 3:
                intent.setClass(getContext(), TestListView.class);
                break;
            case 4:
                intent.setClass(getContext(), Main2Activity.class);

                break;
             case 5:
                intent.setClass(getContext(), Main3Activity.class);

                break;

            default:
                intent.setClass(getContext(), TestDesgin.class);
                break;
        }

        LOGIN();
//        startActivity(intent);
    }


    private void LOGIN() {
        final String account = "zhangzhongzhi";
        final String token   = "zhangzhongzhi";
        try {
            NIMClient.getService(AuthService.class).
                    login(new LoginInfo(account, token)).
                    setCallback(new RequestCallback<LoginInfo>() {
                        @Override
                        public void onSuccess(LoginInfo param) {
                            Log.e(TAG, "login success");

//				onLoginDone();
/*	DemoCache.setAccount(account);
saveLoginInfo(account, token);
*/
// 初始化消息提醒
//				NIMClient.toggleNotification(UserPreferences.getNotificationToggle());

// 初始化免打扰
/*	if (UserPreferences.getStatusConfig() == null) {
UserPreferences.setStatusConfig(DemoCache.getNotificationConfig());
}
NIMClient.updateStatusBarNotificationConfig(UserPreferences.getStatusConfig());

// 构建缓存
DataCacheManager.buildDataCacheAsync();
*//**/
/*	// 进入主界面
MainActivity.start(LoginActivity.this, null);
finish();*/
                        }


                        @Override
                        public void onFailed(int code) {
//				onLoginDone();
                            Log.e(TAG, "login shi" + code);

                        }


                        @Override
                        public void onException(Throwable exception) {
/*Toast.makeText(LoginActivity.this, R.string.login_exception, Toast.LENGTH_LONG).show();
onLoginDone();*/
                            Log.e(TAG, "login success" + exception.getMessage());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String readAppKey(Context context) {
        try {
            return "5380f881b6c172834ca1c9d4dc4e4d06";
        /*	ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
			if (appInfo != null) {
				return appInfo.metaData.getString("com.netease.nim.appKey");
			}*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void init(View view) {
        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ListViewAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }


    private void getList() {
        listObjects = new ArrayList<ListObject>();
        ListObject object = new ListObject();
        object.setName("dfdf");
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
        listObjects.add(object);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
