package com.udinic.ActivitySplitAnimation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udinic.ActivitySplitAnimation.R;
import com.udinic.ActivitySplitAnimation.utils.FragmentSplitAnimationUtil;

public class Fragment2 extends BaseFragment {
	private View mRootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_two, null, false);
		
		return mRootView;
	}
	
	@Override
	protected void onShowSelf() {
		FragmentSplitAnimationUtil.prepareAnimation(getActivity());
	}
	
	public void animate() {
		FragmentSplitAnimationUtil.animate(getActivity(), 1000);
	}
	
	@Override
	protected boolean onAdvancedBackPressed() {
		hideFragment();
		return true;
	}

}
