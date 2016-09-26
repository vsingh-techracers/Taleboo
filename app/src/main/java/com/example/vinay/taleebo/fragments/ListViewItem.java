package com.example.vinay.taleebo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vinay.taleebo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewItem extends Fragment {


    public ListViewItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_view_item, container, false);
    }

}
