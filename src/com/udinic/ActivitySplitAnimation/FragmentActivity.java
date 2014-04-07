package com.udinic.ActivitySplitAnimation;

import android.os.Bundle;

import com.udinic.ActivitySplitAnimation.fragment.Fragment1;

public class FragmentActivity extends android.support.v4.app.FragmentActivity {
	private Fragment1 mFragmentOne;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		mFragmentOne = new Fragment1();
		getSupportFragmentManager().beginTransaction().replace(R.id.root_layout, mFragmentOne).commit();
	}
	
	@Override
	public void onBackPressed() {
		if(!mFragmentOne.onBackPressed())
			super.onBackPressed();
	}
}
