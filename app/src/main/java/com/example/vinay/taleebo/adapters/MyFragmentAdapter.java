package com.example.vinay.taleebo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by shubham on 5/9/16.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    List<Fragment> listFragments;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
