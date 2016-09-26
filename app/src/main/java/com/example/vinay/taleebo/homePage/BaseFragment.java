package com.example.vinay.taleebo.homePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
	public AppMainActivity mActivity;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mActivity		=	(AppMainActivity) this.getActivity();
	}
	
	public boolean onBackPressed(){
		return false;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data){
		
	}
}
