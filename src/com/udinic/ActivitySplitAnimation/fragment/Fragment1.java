package com.udinic.ActivitySplitAnimation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udinic.ActivitySplitAnimation.R;
import com.udinic.ActivitySplitAnimation.utils.FragmentSplitAnimationUtil;

public class Fragment1 extends BaseFragment {
	private View mRootView;
	private Fragment2 mFragmentTwo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_one, null, false);
		mFragmentTwo = new Fragment2();
		registerFragment(R.id.fragment_two_layer, mFragmentTwo);
		
		mRootView.findViewById(R.id.text_one).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentSplitAnimationUtil.showFragment(getCurrentFragment(), mFragmentTwo);
				mFragmentTwo.animate();
			}
		});

		return mRootView;
	}

}
