package com.io.vov.vitamio.newtest.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.io.vov.vitamio.libray.lib.BaseFragment;
import com.io.vov.vitamio.newtest.app.activity.test.TestActivity;
import com.io.vov.vitamio.newtest.app.adapter.ListViewAdapter;
import com.io.vov.vitamio.newtest.app.bean.ListObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${zhangzz} on 2016/4/7.
 */
public class PlaceholderFragment  extends BaseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private ListView listView;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ListViewAdapter adapter;
    private List<ListObject> listObjects;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
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
        listView.setItemChecked(5,true);
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showToast("点击"+position);
//                Intent intent=new Intent(getActivity(), ChartsActivity.class);
                Intent intent=new Intent(getActivity(), TestActivity.class);
                intent.putExtra("object",listObjects.get(position));
                intent.putExtra("secondObject",listObjects.get(position));
                startActivity(intent);
            }
        });
    }

    private void init(View view) {
        listView= (ListView) view.findViewById(R.id.list_view);
        adapter=new ListViewAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

    }
    private void getList(){
        listObjects=new ArrayList<ListObject>();
        ListObject object=new ListObject();
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
