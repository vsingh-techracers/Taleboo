package com.example.vinay.taleebo.mainFragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import android.widget.TextView;
import android.widget.Toast;
import com.example.vinay.taleebo.City;
import com.example.vinay.taleebo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.example.vinay.taleebo.adapters.MyFragmentAdapter;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.fragments.Gym1;
import com.example.vinay.taleebo.fragments.Gym2;
import com.example.vinay.taleebo.fragments.Gym3;
import com.example.vinay.taleebo.fragments.Gym4;
import com.example.vinay.taleebo.fragments.Gym5;
import com.example.vinay.taleebo.fragments.Gym6;
import com.example.vinay.taleebo.fragments.UpperTabs;
import com.example.vinay.taleebo.homePage.BaseFragment;

public class HomePageFragment extends BaseFragment implements TabHost.OnTabChangeListener{

    private Toolbar toolbar;
    private View homePageView;
   private ViewPager view_pager ;
    private TabHost.TabSpec tabSpec;
   private TabHost tabHost;
    private List<Fragment> listFragments;
    private MyFragmentAdapter  mfAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homePageView = inflater.inflate(R.layout.main_fragment_home, container, false);
        toolbar = (Toolbar) homePageView.findViewById(R.id.app_bar);
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView)homePageView.findViewById(R.id.horizontalScrollView);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        String[] cityIdetifier ={City.CITY_INDORE,City.CITY_BHOPAL,City.CITY_DEFAULT};
        createCity(cityIdetifier[0]);


        String[] tabNames = {"All", "Culture", "Sports", "Music", "Gaming"};
       listFragments = new ArrayList<>();
        listFragments.add(new FragmentAll());
        listFragments.add(new FragmentCulture());
        listFragments.add(new FragmentSports());
        listFragments.add(new FragmentMusic());
        listFragments.add(new FragmentGaming());
        initTabHost(tabNames);
        initViewPager(listFragments);
        return homePageView;
/*
        mStacks = new HashMap<String, Stack<Fragment>>();
        mStacks.put(UpperTabs.ENTERTAINMENT_TAB_A, new Stack<Fragment>());
        mStacks.put(UpperTabs.ENTERTAINMENT_TAB_B, new Stack<Fragment>());
        mStacks.put(UpperTabs.ENTERTAINMENT_TAB_C, new Stack<Fragment>());
        mStacks.put(UpperTabs.ENTERTAINMENT_TAB_D, new Stack<Fragment>());
        mStacks.put(UpperTabs.ENTERTAINMENT_TAB_E, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_A, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_B, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_C, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_D, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_E, new Stack<Fragment>());
        mStacks.put(UpperTabs.GYM_TAB_F, new Stack<Fragment>());
        mStacks.put(UpperTabs.TREKKING_TAB_A, new Stack<Fragment>());
        mStacks.put(UpperTabs.TREKKING_TAB_B, new Stack<Fragment>());
        mStacks.put(UpperTabs.TREKKING_TAB_C, new Stack<Fragment>());
        mStacks.put(UpperTabs.TREKKING_TAB_D, new Stack<Fragment>());
        mStacks.put(UpperTabs.TREKKING_TAB_E, new Stack<Fragment>());


        String[] tabIdetifier = {UpperTabs.ENTERTAINMENT_TAB_A, UpperTabs.ENTERTAINMENT_TAB_B,
                UpperTabs.ENTERTAINMENT_TAB_C, UpperTabs.ENTERTAINMENT_TAB_D,
                UpperTabs.ENTERTAINMENT_TAB_E,};
        Fragment[] fragments = {new FragmentAll(),new FragmentCulture(),new FragmentSports(),
                new FragmentMusic(),new FragmentGaming()};
        initializeTabs(tabNames,tabIdetifier,fragments);*/
    }

    private void createCity(String s) {
        String requestedCity = s;
        int[] cityImages = {R.drawable.image2,R.drawable.image1,R.drawable.image2,
                R.drawable.image5,R.drawable.image5,R.drawable.image2};
        String[] cityImagesText ={"Surfing","Gym","Trekking","Travelling","Gaming","Outing",};
        createCardView(cityImages,cityImagesText);

    }

    private void createCardView(int[] cityImages, String[] cityImagesText) {

        LinearLayout ll= (LinearLayout)homePageView.findViewById(R.id.linear_card_view);
        for(int i=0;i<cityImages.length;i++){
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_card_view, null);
            CardView cView = (CardView) view.findViewById(R.id.card_view2);
            TextView tv =   (TextView)view.findViewById(R.id.common_text);
            tv.setText(cityImagesText[i]);
            ImageView iv = (ImageView) view.findViewById(R.id.common_image);
            iv.setImageResource(cityImages[i]);
            final int finalI = i;
            cView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(finalI==0)
                    {
                        String[] tabNames1 = {"All", "Culture", "Sports", "Music", "Gaming"};
                      //listFragments.clear();
                        List<Fragment>  listFragments1=new ArrayList<Fragment>();
                        listFragments1.add(new FragmentAll());
                        listFragments1.add(new FragmentCulture());
                        listFragments1.add(new FragmentSports());
                        listFragments1.add(new FragmentMusic());
                        listFragments1.add(new FragmentGaming());
                        initTabHost(tabNames1);
                        initViewPager(listFragments1);
                        notifyPagerAdapter();
                    }else if(finalI==1){
                        String[] tabNames2 = {"Gym", "Health", "Diet", "Benefits", "Time","Popular"};
                       //listFragments.clear();
                        List<Fragment>  listFragments2=new ArrayList<Fragment>();
                        listFragments2.add(new Gym1());
                        listFragments2.add(new Gym2());
                        listFragments2.add(new Gym3());
                        listFragments2.add(new Gym4());
                        listFragments2.add(new Gym5());
                        listFragments2.add(new Gym6());
                        initTabHost(tabNames2);
                        initViewPager(listFragments2);
                       notifyPagerAdapter();
                    }else if(finalI==2){

                    }else if(finalI==3){

                    }else if(finalI==4){

                    }else if(finalI==5){

                    }else if(finalI==6){

                    }
                }
            });
            ll.addView(view,i);
        }
    }

    private void notifyPagerAdapter(){
        mfAdapter.notifyDataSetChanged();
    }
  /*  private View createTabView(String str) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.inner_tabs_icon, null);
        TextView tv = (TextView) view.findViewById(R.id.tab_text);
        tv.setText(str);
        return view;
    }*/

   /* private void initializeTabs(String[] tabs, String[] tabIdetifier, final Fragment[] fragments) {

        if (mTabHost != null) {
            mTabHost.clearAllTabs();
            mTabHost = null;
        }
        mTabHost = (TabHost) homePageView.findViewById(android.R.id.tabhost);
        mTabHost.setOnTabChangedListener(listener);
        mTabHost.setup();
        TabHost.TabSpec spec;
        mTabHost.setCurrentTab(0);

        for (int i = 0; i<tabs.length; i++) {
            spec = mTabHost.newTabSpec(tabIdetifier[i]);
            final int finalI = i;
            spec.setContent(new TabHost.TabContentFactory() {
                public View createTabContent(String tag) {
                    setTargetFragment(fragments[finalI], finalI);
                    return homePageView.findViewById(R.id.realtabcontent2);
                }
            });
            spec.setIndicator(createTabView(tabs[i]));
            mTabHost.addTab(spec);
        }
    }

    TabHost.OnTabChangeListener listener = new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {
            mCurrentTab = tabId;
            if (mStacks.get(tabId).size() == 0) {

                    if (tabId.equals(UpperTabs.ENTERTAINMENT_TAB_A)) {
                        pushFragments(tabId, new FragmentAll(), true);
                    } else if (tabId.equals(UpperTabs.ENTERTAINMENT_TAB_B)) {
                        pushFragments(tabId, new FragmentCulture(), true);
                    } else if (tabId.equals(UpperTabs.ENTERTAINMENT_TAB_C)) {
                        pushFragments(tabId, new FragmentSports(), true);
                    } else if (tabId.equals(UpperTabs.ENTERTAINMENT_TAB_D)) {
                        pushFragments(tabId, new FragmentMusic(), true);
                    } else if (tabId.equals(UpperTabs.ENTERTAINMENT_TAB_E)) {
                        pushFragments(tabId, new FragmentGaming(), true);

                        *//*fragments for Gym Image*//*
                    }else if (tabId.equals(UpperTabs.GYM_TAB_A)) {
                    pushFragments(tabId, new Gym1(), true);
                } else if (tabId.equals(UpperTabs.GYM_TAB_B)) {
                    pushFragments(tabId, new Gym2(), true);
                } else if (tabId.equals(UpperTabs.GYM_TAB_C)) {
                    pushFragments(tabId, new Gym3(), true);
                } else if (tabId.equals(UpperTabs.GYM_TAB_D)) {
                    pushFragments(tabId, new Gym4(), true);
                } else if (tabId.equals(UpperTabs.GYM_TAB_E)) {
                    pushFragments(tabId, new Gym5(), true);
                } else if (tabId.equals(UpperTabs.GYM_TAB_E)) {
                        pushFragments(tabId, new Gym6(), true);
                    }
            }
            else {
                pushFragments(tabId, mStacks.get(tabId).lastElement(), false);
            }
        }
    };

    public void pushFragments(String tag, Fragment fragment, boolean shouldAdd) {
        if (shouldAdd)
            mStacks.get(tag).push(fragment);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.realtabcontent2, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
*/

    private void initTabHost(String[] tabs) {
        if (tabHost != null) {
            tabHost.clearAllTabs();
            tabHost = null;
        }
        tabHost = (TabHost)homePageView.findViewById(R.id.tabHost);
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

    public void initViewPager(List<Fragment> listFragments) {
        if (view_pager!=null){
            view_pager.removeAllViews();
            view_pager=null;
        }
        view_pager =(ViewPager)homePageView.findViewById(R.id.HomemainViewpager);
        mfAdapter =new MyFragmentAdapter(getChildFragmentManager(),listFragments);

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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onBackPressed() {
        return super.onBackPressed();
    }
}
