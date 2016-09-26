package com.example.vinay.taleebo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vinay.taleebo.fragments.FragmentCulture;
import com.example.vinay.taleebo.mainFragments.HomePageFragment;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    private static int mCurrenttab;
    private static HomePageFragment homePageFragment;
    private static FragmentCulture fragmentCulture =new FragmentCulture();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homePageFragment = new HomePageFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, homePageFragment).commit();
        initTabLayout();


    }

    private void initTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_person));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_person));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_keyboard));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_person));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_person));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        mCurrenttab = tab.getPosition();
        tab.select();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mCurrenttab =tab.getPosition();
                if(mCurrenttab==0){
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, homePageFragment).commit();

                }

                else if(mCurrenttab==1){
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragmentCulture).commit();

                }
                else if(mCurrenttab==2){
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragmentCulture).commit();

                }
                else if(mCurrenttab==3){
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragmentCulture).commit();
                }
                else if(mCurrenttab==4){
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragmentCulture).commit();

                }
                Toast.makeText(HomeActivity.this, "You are in tab No "+mCurrenttab, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}