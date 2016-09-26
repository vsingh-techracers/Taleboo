package com.example.vinay.taleebo.mainFragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinay.taleebo.R;
import com.example.vinay.taleebo.adapters.MyFragmentAdapter;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.fragments.UpperTabs;
import com.example.vinay.taleebo.homePage.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalenderFragment extends BaseFragment implements TabHost.OnTabChangeListener {

    View mainView;
    ViewPager view_pager;
    TabHost.TabSpec tabSpec;
    TabHost tabHost;
    MyFragmentAdapter mfAdapter;
    String[] tabNames ={"All","Culture","Sports","Music","Gaming"};

    public CalenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.main_fragment_calender, container, false);
        view_pager =(ViewPager)mainView.findViewById(R.id.mainViewpager);
        tabHost = (TabHost)mainView.findViewById(R.id.tabHost1);
        initTabHost(tabNames);
        initViewPager();
        return mainView;
    }


    private void initTabHost(String[] tabs) {

        tabHost.setup();
        tabHost.setCurrentTab(0);
        for (int i=0;i<tabs.length;i++){

        tabSpec =tabHost.newTabSpec(tabs[i]);
        tabSpec.setIndicator(tabs[i]);
        tabSpec.setContent(new FakeContent(getActivity().getApplicationContext()));
        tabHost.addTab(tabSpec);
        TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
        tv.setTextColor(Color.parseColor("#d84830"));
        tv.setTextSize(12);
        }
        tabHost.setOnTabChangedListener(this);
    }

    public class FakeContent implements TabHost.TabContentFactory{

        Context context;

        public FakeContent(Context mcontext){
            context=mcontext;
        }

        @Override
        public View createTabContent(String s) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    public void initViewPager() {

        List<Fragment> listFragments = new ArrayList<>();
        listFragments.add(new FragmentAll());
        listFragments.add(new FragmentCulture());
        listFragments.add(new FragmentSports());
        listFragments.add(new FragmentMusic());
        listFragments.add(new FragmentGaming());
        mfAdapter =new MyFragmentAdapter(getActivity().getSupportFragmentManager(),listFragments);
        view_pager.setAdapter(mfAdapter);
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int seletedItem) {
                tabHost.setCurrentTab(seletedItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabChanged(String s) {
        int selectedPage = tabHost.getCurrentTab();
        view_pager.setCurrentItem(selectedPage);

    }




}
