package com.example.vinay.taleebo.mainFragments;


import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.vinay.taleebo.City;
import com.example.vinay.taleebo.R;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.fragments.UpperTabs;
import com.example.vinay.taleebo.homePage.BaseFragment;

import java.util.HashMap;
import java.util.Stack;

/**
 * A simple {@link Fragment} subclass.
 */
public class CafeFragment extends BaseFragment {

    private TabHost mTabHost;
    private HashMap<String, Stack<Fragment>> mStacks;
    private String mCurrentTab;
    private Toolbar toolbar;
    private View homePageView1;
    private FragmentTabHost tabHost;

    public CafeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        // Toast.makeText(getActivity(), "HomePageFragmet onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homePageView1 = inflater.inflate(R.layout.main_fragment_cafe,container,false);
        toolbar = (Toolbar)homePageView1.findViewById(R.id.app_bar1);
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        String[] cityIdetifier ={City.CITY_INDORE,City.CITY_BHOPAL,City.CITY_DEFAULT};
        createCity(cityIdetifier[0]);
/*
        tabHost = (FragmentTabHost) homePageView1.findViewById(R.id.fragmentTabhost);
        
        initFragmentTabHost();

        tabHost.setup(getActivity(),getFragmentManager()*//* getChildFragmentManager()*//*, R.layout.main_fragment_cafe);

        Bundle arg1 = new Bundle();
        arg1.putInt("Arg for Frag1", 1);
        tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("Latest Videos"), FragmentAll.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt("Arg for Frag2", 2);
        tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("Hot Videos"), FragmentCulture.class, arg2);

        Bundle arg3 = new Bundle();
        arg3.putInt("Arg for Frag2", 3);
        tabHost.addTab(tabHost.newTabSpec("Tab3").setIndicator("My Videos"), FragmentGaming.class, arg3);

        Bundle arg4 = new Bundle();
        arg4.putInt("Arg for Frag2", 4);
        tabHost.addTab(tabHost.newTabSpec("Tab4").setIndicator("Videos"), FragmentMusic.class, arg4);

        Bundle arg5 = new Bundle();
        arg5.putInt("Arg for Frag2", 5);
        tabHost.addTab(tabHost.newTabSpec("Tab5").setIndicator("Sample Videos"), FragmentSports.class, arg5);

        TabWidget tw = (TabWidget) homePageView1.findViewById(R.id.tabs);
        LinearLayout ll = (LinearLayout) tw.getParent();
        HorizontalScrollView hs = new HorizontalScrollView(this.getActivity());
        hs.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        ll.addView(hs, 0);
        ll.removeView(tw);
        hs.addView(tw);
        hs.setHorizontalScrollBarEnabled(false);
        *//*return tabHost;*/

        return homePageView1;
    }

   /* private void initFragmentTabHost() {
    }*/

    private void createCity(String s) {
        String requestedCity = s;
        int[] cityImages = {R.drawable.image1,R.drawable.image1,R.drawable.image1,
                R.drawable.image1,R.drawable.image1,R.drawable.image1};
        String[] cityImagesText ={"Surfing","Gym","Trekking","Surfing","Surfing","Surfing",};
        createCardView(cityImages,cityImagesText);

    }

    private void createCardView(int[] cityImages, String[] cityImagesText) {

        LinearLayout ll= (LinearLayout)homePageView1.findViewById(R.id.linear);

        for(int i=0;i<cityImages.length;i++){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_card_view, null);
        TextView tv =   (TextView)view.findViewById(R.id.common_text);
        tv.setText(cityImagesText[i]);
        tv.setTextColor(Color.parseColor("#d84830"));
        tv.setTextSize(12);
        ImageView iv = (ImageView) view.findViewById(R.id.common_image);
        iv.setImageResource(cityImages[i]);
        ll.addView(view ,i);
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

}
