package com.io.vov.vitamio.newtest.app.activity.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.io.vov.vitamio.libray.lib.BaseActivity;
import com.io.vov.vitamio.libray.lib.BaseFragment;
import com.io.vov.vitamio.newtest.app.R;
import com.io.vov.vitamio.newtest.app.adapter.RecycleAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by ${zhangzz} on 2016/8/2.
 */
public class TestDesgin extends BaseActivity {

    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_design);
        init();
    }


    private void init() {
        pager= (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));

    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:

                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends BaseFragment {
        RecyclerView listView;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";


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


        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            listView= (RecyclerView) rootView.findViewById(R.id.list_view);
            listView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
            listView.setLayoutManager(layoutManager);
            listView.setAdapter(new RecycleAdapter(getStringList(), getActivity()));
            return rootView;
        }
        private List<String> getStringList() {
            String []s=new String[]{
                    "22",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",   "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
                    "11111",
            };

            return Arrays.asList(s);
        }
    }



}
