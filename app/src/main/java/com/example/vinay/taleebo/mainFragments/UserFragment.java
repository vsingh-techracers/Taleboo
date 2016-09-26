package com.example.vinay.taleebo.mainFragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.vinay.taleebo.R;
import com.example.vinay.taleebo.adapters.MyFragmentAdapter;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements TabHost.OnTabChangeListener{


    private  View mainView;
   private TabHost.TabSpec tabSpec;
    private TabHost tabHost;
    private String[] tabNames ={"All","Culture","Sports","Music","Gaming"};
    private LinearLayout mainTabContent;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.main_fragment_user, container, false);
        tabHost = (TabHost)mainView.findViewById(R.id.usertabHost);
        mainTabContent =(LinearLayout)mainView.findViewById(R.id.userRealTabcontent);
        initTabHost(tabNames);
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
             View fakeView = LayoutInflater.from(getActivity()).inflate(R.layout.common_tabcontent, null);
            //LinearLayout commonTabcontent = (LinearLayout)fakeView.findViewById(R.id.common_tabcontent);
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.add(R.id.common_tabcontent, new FragmentAll());
                    ft.addToBackStack(null);
                    ft.commit();
            mainTabContent.addView(fakeView);
            return mainTabContent;
        }
    }

    @Override
    public void onTabChanged(String s) {
        int selectedPage = tabHost.getCurrentTab();
        if (selectedPage==0){
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.common_tabcontent, new FragmentAll());
            ft.commit();
        }else if (selectedPage==1){
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.common_tabcontent, new FragmentGaming());
            ft.addToBackStack(null);
            ft.commit();
        }else if (selectedPage==2){
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.common_tabcontent, new FragmentMusic());
            ft.addToBackStack(null);
            ft.commit();
        }else if (selectedPage==3){
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.common_tabcontent, new FragmentCulture());
            ft.addToBackStack(null);
            ft.commit();
        }else if (selectedPage==4){
            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.common_tabcontent, new FragmentSports());
            ft.addToBackStack(null);
            ft.commit();
        }


    }



}
