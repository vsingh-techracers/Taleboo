package com.example.vinay.taleebo.homePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.vinay.taleebo.R;
import com.example.vinay.taleebo.fragments.FragmentAll;
import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.fragments.FragmentGaming;
import com.example.vinay.taleebo.fragments.FragmentMusic;
import com.example.vinay.taleebo.fragments.FragmentSports;
import com.example.vinay.taleebo.mainFragments.CafeFragment;
import com.example.vinay.taleebo.mainFragments.CalenderFragment;
import com.example.vinay.taleebo.mainFragments.CalenderFragment2;
import com.example.vinay.taleebo.mainFragments.HomePageFragment;
import com.example.vinay.taleebo.mainFragments.NotificationFragment;
import com.example.vinay.taleebo.mainFragments.UserFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by shubham on 7/9/16.
 */
public class AppMainActivity extends AppCompatActivity {

    private TabHost mTabHost;
    private HashMap<String, Stack<Fragment>> mStacks;
    private String mCurrentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_new);

        if (savedInstanceState == null) {
            CalenderFragment2 frag = new CalenderFragment2();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.realtabcontent, frag).commit();
        }

        mStacks             =   new HashMap<String, Stack<Fragment>>();
        mStacks.put(BottomTabs.TAB_A, new Stack<Fragment>());
        mStacks.put(BottomTabs.TAB_B, new Stack<Fragment>());
        mStacks.put(BottomTabs.TAB_C, new Stack<Fragment>());
        mStacks.put(BottomTabs.TAB_D, new Stack<Fragment>());
        mStacks.put(BottomTabs.TAB_E, new Stack<Fragment>());

        mTabHost =   (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setOnTabChangedListener(listener);
        mTabHost.setup();
        Toast.makeText(AppMainActivity.this, "HomePageMainActivity onCreate()", Toast.LENGTH_SHORT).show();
        initializeTabs();
    }


    private View createTabView(final int id) {
        View view = LayoutInflater.from(this).inflate(R.layout.tabs_icon, null);
        ImageView imageView =   (ImageView) view.findViewById(R.id.tab_icon);
        imageView.setImageDrawable(getResources().getDrawable(id));
        return view;
    }

    private void initializeTabs() {
        TabHost.TabSpec spec    =   mTabHost.newTabSpec(BottomTabs.TAB_A);
        mTabHost.setCurrentTab(-3);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_a_state_btn));
        mTabHost.addTab(spec);


        spec                    =   mTabHost.newTabSpec(BottomTabs.TAB_B);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_b_state_btn));
        mTabHost.addTab(spec);

        spec                    =   mTabHost.newTabSpec(BottomTabs.TAB_C);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_c_state_btn));
        mTabHost.addTab(spec);

        spec                    =   mTabHost.newTabSpec(BottomTabs.TAB_D);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_d_state_btn));
        mTabHost.addTab(spec);

        spec                    =   mTabHost.newTabSpec(BottomTabs.TAB_E);
        spec.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
        spec.setIndicator(createTabView(R.drawable.tab_e_state_btn));
        mTabHost.addTab(spec);
    }

    TabHost.OnTabChangeListener listener    =   new TabHost.OnTabChangeListener() {
        public void onTabChanged(String tabId) {

        /*Set current tab..*/
            mCurrentTab                     =   tabId;

            if(mStacks.get(tabId).size() == 0){
          /*
           *    First time this tab is selected. So add first fragment of that tab.
           *    Dont need animation, so that argument is false.
           *    We are adding a new fragment which is not present in stack. So add to stack is true.
           */
                if(tabId.equals(BottomTabs.TAB_A)){
                    pushFragments(tabId, new HomePageFragment(), true);
                }else if(tabId.equals(BottomTabs.TAB_B)){
                    pushFragments(tabId, new CafeFragment(),true);
                }else if(tabId.equals(BottomTabs.TAB_C)){
                    pushFragments(tabId, new CalenderFragment(),true);
                }else if(tabId.equals(BottomTabs.TAB_D)){
                    pushFragments(tabId, new CalenderFragment2(),true);
                }else if(tabId.equals(BottomTabs.TAB_E)){
                    pushFragments(tabId, new UserFragment(),true);
                }
            }else {
          /*
           *    We are switching tabs, and target tab is already has atleast one fragment.
           *    No need of animation, no need of stack pushing. Just show the target fragment
           */
                pushFragments(tabId, mStacks.get(tabId).lastElement(),false);
            }
        }
    };

    public void pushFragments(String tag, Fragment fragment, boolean shouldAdd){
        if(shouldAdd)
            mStacks.get(tag).push(fragment);
        FragmentManager manager         =   getSupportFragmentManager();
        FragmentTransaction ft            =   manager.beginTransaction();
        ft.replace(R.id.realtabcontent, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void popFragments(){
      /*
       *    Select the second last fragment in current tab's stack..
       *    which will be shown after the fragment transaction given below
       */
        Fragment fragment             =   mStacks.get(mCurrentTab).elementAt(mStacks.get(mCurrentTab).size() - 2);

      /*pop current fragment from stack.. */
        mStacks.get(mCurrentTab).pop();

      /* We have the target fragment in hand.. Just show it.. Show a standard navigation animation*/
        FragmentManager   manager         =   getSupportFragmentManager();
        FragmentTransaction ft            =   manager.beginTransaction();
        ft.replace(R.id.realtabcontent, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

   /* @Override
    protected void onStart() {
        super.onStart();
       Toast.makeText(AppMainActivity.this, "HomePageMainActivity onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
      Toast.makeText(AppMainActivity.this, "HomeActivity onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
       // Toast.makeText(AppMainActivity.this, "Main Activity onPostResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(AppMainActivity.this, "HomeActivity onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(AppMainActivity.this, "HomeActivity onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(AppMainActivity.this, "HomeActivity onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(AppMainActivity.this, "Home Activity onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(AppMainActivity.this, "Home Activity onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(AppMainActivity.this, "Home Activity onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        Toast.makeText(AppMainActivity.this, "Home Activity onResumeFragments()", Toast.LENGTH_SHORT).show();
    }
*/
    @Override
    public void onBackPressed() {
        if(((BaseFragment)mStacks.get(mCurrentTab).lastElement()).onBackPressed() == false){
       		/*
       		 * top fragment in current tab doesn't handles back press, we can do our thing, which is
       		 *
       		 * if current tab has only one fragment in stack, ie first fragment is showing for this tab.
       		 *        finish the activity
       		 * else
       		 *        pop to previous fragment in stack for the same tab
       		 *
       		 */
            if(mStacks.get(mCurrentTab).size() == 1){
                super.onBackPressed();  // or call finish..
            }else{
                popFragments();
            }
        }else{
            //do nothing.. fragment already handled back button press.
        }
    }


    /*
     *   Imagine if you wanted to get an image selected using ImagePicker intent to the fragment. Ofcourse I could have created a public function
     *  in that fragment, and called it from the activity. But couldn't resist myself.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mStacks.get(mCurrentTab).size() == 0){
            return;
        }

        /*Now current fragment on screen gets onActivityResult callback..*/
        mStacks.get(mCurrentTab).lastElement().onActivityResult(requestCode, resultCode, data);
    }


}
