package com.example.vinay.taleebo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vinay.taleebo.R;

/**
 * Created by shubham on 5/9/16.
 */
public class FragmentMusic extends Fragment {

    String[] itemname ={ "item 1", "item 2", "item 3"};
    ListView my_list4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_music,container,false);
        my_list4= (ListView)v.findViewById(R.id.list_view_music);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemname);

        my_list4.setAdapter(adapter);

        return v;
    }
}
