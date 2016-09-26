package com.example.vinay.taleebo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ravindu1024.indicatorlib.ViewPagerIndicator;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdapter adapter;
    Button loginWithfb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(adapter);
        final ViewPagerIndicator indicator = (ViewPagerIndicator) findViewById(R.id.pager_indicator);
        indicator.setPager(viewPager);  //pager - the target ViewPager
        indicator.setOnIndicatorItemClickListener(new ViewPagerIndicator.OnIndicatorItemClickListener() {
            @Override
            public void onItemClick(View view) {
                viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
            }
        });
        loginWithfb =(Button)findViewById(R.id.login_button);
        loginWithfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });


    }
}
