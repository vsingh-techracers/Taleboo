package com.example.vinay.taleebo.mainFragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.vinay.taleebo.R;
import com.example.vinay.taleebo.adapters.MyFragmentAdapter;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.homePage.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFragment2 extends BaseFragment {

    private static final String DATA_ARGS_KEY = "PagerFragment.DATA_ARGS_KEY";

    private List<String> data;
    View mainView;
    private ViewPager pagerData;
 ViewPager view_pager;
    MyFragmentAdapter mfAdapter;
    //
    String[] tabNames ={"All","Culture","Sports","Music","Gaming"};

    /*public CalenderFragment2() {
        // Required empty public constructor
    }*/

   /* public static CalenderFragment2 newInstance(List<Fragment> data) {
        CalenderFragment2 pagerFragment = new CalenderFragment2();
        Bundle args = new Bundle();
        ArrayList<Fragment> argsValue = new ArrayList<Fragment>(data);
        args.putStringArrayList(DATA_ARGS_KEY, argsValue);
        pagerFragment.setArguments(args);
        return CalenderFragment2;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.main_fragment_calender2, container, false);
        view_pager =(ViewPager)mainView.findViewById(R.id.mainViewpager);
        initViewPager();
        return mainView;
    }


    public void initViewPager() {

        List<Fragment> listFragments = new ArrayList<>();
        listFragments.add(new FragmentAll());
        listFragments.add(new FragmentCulture());
        listFragments.add(new FragmentSports());
        listFragments.add(new FragmentMusic());
        listFragments.add(new FragmentGaming());
        MyFragmentAdapter  mfAdapter =new MyFragmentAdapter(getChildFragmentManager(),listFragments);
        view_pager.setAdapter(mfAdapter);

    }


    /*private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           *//* Fragment frag = null;
            switch (position) {
                case 0:
                    return frag=FragmentAll.newInstance();

                case 1:
                    return frag=FragmentAll.newInstance();
                case 2:
                    return frag=FragmentAll.newInstance();
                case 3:
                    return frag=FragmentAll.newInstance();
                case 4:
                    return frag=FragmentAll.newInstance();
            }
            return frag;*//*
            return FragmentAll.newInstance();
        }

        @Override
        public int getCount() {
            return 5;
        }

    }*/

    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        pagerData = (ViewPager) view.findViewById(R.id.pager_data);
        setupPagerData();
    }*/
/*
    private void setupPagerData() {
        PagerAdapter adapter = new LocalPagerAdapter(getChildFragmentManager(), data);
        pagerData.setAdapter(adapter);
    }*/


}
