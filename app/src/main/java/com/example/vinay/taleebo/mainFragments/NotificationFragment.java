package com.example.vinay.taleebo.mainFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.fragments.UpperTabs;

import java.util.HashMap;
import java.util.Stack;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment_notification, container, false);
    }

  /*  private TabHost mTabHost;
    private HashMap<String, Stack<Fragment>> mStacks;
    private String mCurrentTab;
    private Toolbar toolbar;
    private View homePageView;
    View CommonTabview;
    //private FrameLayout commonTabcontent;
    private LinearLayout mainTabContent;


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
        mStacks = new HashMap<String, Stack<Fragment>>();
        mStacks.put(UpperTabs.UPPER_TAB_A, new Stack<Fragment>());
        mStacks.put(UpperTabs.UPPER_TAB_B, new Stack<Fragment>());
        mStacks.put(UpperTabs.UPPER_TAB_C, new Stack<Fragment>());
        mStacks.put(UpperTabs.UPPER_TAB_D, new Stack<Fragment>());
        mStacks.put(UpperTabs.UPPER_TAB_E, new Stack<Fragment>());


        String[] tabNames = {"All", "Culture", "Sports", "Music", "Gaming"};
        String[] tabIdetifier = {UpperTabs.UPPER_TAB_A, UpperTabs.UPPER_TAB_B, UpperTabs.UPPER_TAB_C,UpperTabs.UPPER_TAB_D,UpperTabs.UPPER_TAB_E};
        Fragment[] fragments = {new FragmentAll(),new FragmentCulture(),new FragmentSports(),new FragmentMusic(),new FragmentGaming()};
        mainTabContent = (LinearLayout)homePageView.findViewById(R.id.realtabcontent2);
        initializeTabs(tabNames,tabIdetifier,fragments);
        return homePageView;
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
                        String[] tabNames = {"All", "Culture", "Sports", "Music", "Gaming"};
                        String[] tabIdetifier = {UpperTabs.UPPER_TAB_A, UpperTabs.UPPER_TAB_B, UpperTabs.UPPER_TAB_C, UpperTabs.UPPER_TAB_D,
                                UpperTabs.UPPER_TAB_E,};
                        Fragment[] fragments = {new FragmentAll(),new FragmentCulture(),new FragmentSports(),new FragmentMusic(),new FragmentGaming()};
                        initializeTabs(tabNames, tabIdetifier,fragments);
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();
                    }else if(finalI==1){
                        String[] tabNames1 = {"All", "Gym2", "Gym3", "Gym4", "Gym5"};

                        String[] tabIdetifier1 = {UpperTabs.UPPER_TAB_E, UpperTabs.UPPER_TAB_B, UpperTabs.UPPER_TAB_A, UpperTabs.UPPER_TAB_D,
                                UpperTabs.UPPER_TAB_E,};
                        Fragment[] fragments = {new FragmentGaming(),new FragmentAll(),new FragmentCulture(),new FragmentMusic(),new FragmentSports()};
                        initializeTabs(tabNames1, tabIdetifier1,fragments);
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }else if(finalI==2){
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }else if(finalI==3){
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }else if(finalI==4){
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }else if(finalI==5){
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }else if(finalI==6){
                        Toast.makeText(getActivity(), "Card View "+ finalI, Toast.LENGTH_SHORT).show();

                    }
                }
            });
            ll.addView(view , i);
        }
        *//*for(int i=0;i<cityImages.length;i++){
            ll.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   *//**//* String[] tabNames1 = {"1", "2", "3", "4", "5"};
                    String[] tabIdetifier1 = {UpperTabs.UPPER_TAB_A, UpperTabs.UPPER_TAB_B, UpperTabs.UPPER_TAB_C, UpperTabs.UPPER_TAB_D,
                            UpperTabs.UPPER_TAB_E,};
                    Fragment[] fragments = {new CafeFragment(),new CafeFragment(),new CafeFragment(),new CafeFragment(),new CafeFragment()};
                    initializeTabs(tabNames1, tabIdetifier1,fragments);*//**//*
                    Toast.makeText(getActivity(), "Card View 2 ", Toast.LENGTH_SHORT).show();
                }
            });
        }*//*


    }

    private View createTabView(String str ) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.inner_tabs_icon, null);
        TextView tv = (TextView) view.findViewById(R.id.tab_text);
        tv.setText(str);
        return view;
    }

    private void initializeTabs(String[] tabs, String[] tabIdetifier, final Fragment[] fragments) {

        if (mTabHost != null) {
            mTabHost.clearAllTabs();
            mTabHost = null;
        }
        mTabHost = (TabHost) homePageView.findViewById(android.R.id.tabhost);


        mTabHost.setup();
        mTabHost.setOnTabChangedListener(listener);
        TabHost.TabSpec spec;
        // mTabHost.setCurrentTab(-3);

        for (int i = 0; i<tabs.length; i++) {

            spec = mTabHost.newTabSpec(tabIdetifier[i]);

            final int finalI = i;
            spec.setContent(new TabHost.TabContentFactory() {
                public View createTabContent(String tag) {
                    CommonTabview= LayoutInflater.from(getActivity()).inflate(R.layout.common_tabcontent, null);
                    FrameLayout commonTabcontent = (FrameLayout) CommonTabview.findViewById(R.id.common_tabcontent);
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.add(R.id.common_tabcontent, fragments[finalI]);
                    ft.commit();
                    mainTabContent.addView(commonTabcontent);
                    return mainTabContent;
                }
            });
            spec.setIndicator(createTabView(tabs[i]));
            mTabHost.addTab(spec);


        }


    }

    TabHost.OnTabChangeListener listener = new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {
            mCurrentTab = tabId;
            Toast.makeText(getActivity(), " " +mCurrentTab, Toast.LENGTH_SHORT).show();
            if (mStacks.get(tabId).size() == 0) {

                if (tabId.equals(UpperTabs.UPPER_TAB_A)) {
                    pushFragments(tabId, new FragmentAll(), true);
                } else if (tabId.equals(UpperTabs.UPPER_TAB_B)) {
                    pushFragments(tabId, new FragmentCulture(), true);
                } else if (tabId.equals(UpperTabs.UPPER_TAB_C)) {
                    pushFragments(tabId, new FragmentSports(), true);
                } else if (tabId.equals(UpperTabs.UPPER_TAB_D)) {
                    pushFragments(tabId, new FragmentMusic(), true);
                } else if (tabId.equals(UpperTabs.UPPER_TAB_E)) {
                    pushFragments(tabId, new FragmentGaming(), true);
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
        ft.replace(R.id.common_tabcontent, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
*//*
    public void popFragments(){



        Fragment fragment             =   mStacks.get(mCurrentTab).elementAt(mStacks.get(mCurrentTab).size() - 2);

        mStacks.get(mCurrentTab).pop();

        FragmentManager   manager         =   getActivity().getSupportFragmentManager();
        FragmentTransaction ft            =   manager.beginTransaction();
        ft.replace(R.id.realtabcontent2, fragment);
        ft.commit();
    }
    *//*


   *//* @Override
    public void onBackPressed() {
        if(((BaseFragment)mStacks.get(mCurrentTab).lastElement()).onBackPressed() == false){
       		*//**//*
       		 * top fragment in current tab doesn't handles back press, we can do our thing, which is
       		 *
       		 * if current tab has only one fragment in stack, ie first fragment is showing for this tab.
       		 *        finish the activity
       		 * else
       		 *        pop to previous fragment in stack for the same tab
       		 *
       		 *//**//*
            if(mStacks.get(mCurrentTab).size() == 1){
                super.onBackPressed();  // or call finish..
            }else{
                popFragments();
            }
        }else{
            //do nothing.. fragment already handled back button press.
        }
    }*//*


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }*/

}
