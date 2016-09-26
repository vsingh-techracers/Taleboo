package com.example.vinay.taleebo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vinay.taleebo.R;

/**
 * Created by shubham on 5/9/16.
 */
public class FragmentAll extends Fragment {


    private int[] list_title_image={R.drawable.row_img,R.drawable.row_img,R.drawable.row_img,
          R.drawable.row_img,R.drawable.row_img};
    private String[] list_title_text ={"Hint Hunt","Forbidden Planet","Soho theatre","Royal Opera House","Pyramid",};
    private String[] list_address_text ={"Address: 48,Pirrama Road, Pyrmont Sharjaha, Dubai","Address: 48,Pirrama Road, Pyrmont Sharjaha, Dubai",
            "Address: 48,Pirrama Road, Pyrmont Sharjaha, Dubai","Address: 48,Pirrama Road, Pyrmont Sharjaha, Dubai","Address: 48,Pirrama Road, Pyrmont Sharjaha, Dubai"};

    private String[] des_text ={"Expensive","Expensive","Expensive","Expensive","Expensive"};
    ListView my_list1;
    ListView my_list2;
    TextView txtRatingValue;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.fragment_all,container,false);
        view =v;
        my_list1= (ListView)v.findViewById(R.id.list_view_all);
        my_list1.setAdapter(new MyArrayAdapter(getActivity(),list_title_text));
        my_list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment newFragment = new ListViewItem();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.realtabcontent, newFragment);
                ft.addToBackStack(null);
                ft.commit();
                Toast.makeText(getActivity(), " position = "+list_title_text[position]+ " Id ="+id, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        my_list2= (ListView)view.findViewById(R.id.list_view_all);
        my_list2.setAdapter(new MyArrayAdapter(getActivity(),list_title_text));
       // Toast.makeText(getActivity(), "FragmentAll onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(getActivity(), "FragmentAll onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        my_list2= (ListView)view.findViewById(R.id.list_view_all);
        my_list2.setAdapter(new MyArrayAdapter(getActivity(),list_title_text));
       // Toast.makeText(getActivity(), "FragmentAll onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        my_list2= (ListView)view.findViewById(R.id.list_view_all);
        my_list2.setAdapter(new MyArrayAdapter(getActivity(),list_title_text));
        //Toast.makeText(getActivity(), "FragmentAll onViewStateRestored()", Toast.LENGTH_SHORT).show();
    }

    public class MyArrayAdapter extends ArrayAdapter<String>{

        private final Context context;
        private final String[] values;


        public MyArrayAdapter(Context context, String[] values) {
            super(context, R.layout.list_item, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.list_item, parent, false);
            TextView title = (TextView) rowView.findViewById(R.id.list_title_text);
            TextView address = (TextView) rowView.findViewById(R.id.list_address_text);
            TextView des = (TextView) rowView.findViewById(R.id.des_text);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.list_title_image);
            RatingBar ratingBar= (RatingBar) rowView.findViewById(R.id.ratingBar);
            ratingBar.setRating(3);
           txtRatingValue =(TextView) rowView.findViewById(R.id.rating_text);
            txtRatingValue.setText("3.0");
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                public void onRatingChanged(RatingBar ratingBar, float rating,
                                            boolean fromUser) {

                  txtRatingValue.setText(String.valueOf(rating));

                }
            });
            imageView.setImageResource(list_title_image[position]);
            title.setText(list_title_text[position]);
            address.setText(list_address_text[position]);
            des.setText(des_text[position]);
            return  rowView;

        }
    }
}
