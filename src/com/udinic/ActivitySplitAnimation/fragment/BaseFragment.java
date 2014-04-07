package com.udinic.ActivitySplitAnimation.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class BaseFragment extends Fragment {

	protected boolean isFragmentActive = false;
	private BaseFragment topFragment;
	private BaseFragment bottomFragment;
	private boolean isBackPressed = false;

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
	}
	
	public BaseFragment getCurrentFragment() {
		return this;
	}

	public final boolean onBackPressed() {
		isBackPressed = true;
		if (topFragment != null) {
			return topFragment.onBackPressed();
		} else {
			if (!onAdvancedBackPressed()) {
				return !hideFragment();
			}
			return true;
		}
	}

	public void clearTopFragment() {
		if (topFragment != null) {
			topFragment.clearTopFragment();
			topFragment.hideFragment();
		}
	}

	public final void registerFragment(int containerId, BaseFragment fragment) {
		try {
			FragmentManager mgr = getActivity().getSupportFragmentManager();
			Fragment added = mgr.findFragmentById(containerId);
			if (added != null) {
				FragmentTransaction trans = mgr.beginTransaction();
				trans.remove(added);
				trans.commit();
			}
			FragmentTransaction trans = mgr.beginTransaction();
			trans.add(containerId, fragment);
			trans.hide(fragment);
			trans.commit();
		} catch (Exception e) {
			Intent intent = getActivity().getIntent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			getActivity().finish();
			startActivity(intent);
		}
	}

	public final void removeFragment(int containerId, BaseFragment fragment) {
		try {
			FragmentManager mgr = getActivity().getSupportFragmentManager();
			Fragment added = mgr.findFragmentById(containerId);
			if (added != null) {
				FragmentTransaction trans = mgr.beginTransaction();
				trans.remove(added);
				trans.commit();
			}
		} catch (Exception e) {
			Intent intent = getActivity().getIntent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			getActivity().finish();
			startActivity(intent);
		}
	}

	public final void showFragment(BaseFragment fragment) {
		showFragment(fragment, true, true);
	}

	public final void showFragment(BaseFragment fragment, boolean animate,
			boolean isChildPushed) {
		fragment.onShowSelf();
		if (isChildPushed)
			pushChild(fragment, animate);
		FragmentTransaction trans = getActivity().getSupportFragmentManager()
				.beginTransaction();
		if (animate) {
			trans.setCustomAnimations(0,0,0,0);
		}

		trans.show(fragment);
		trans.commit();
	}

	public final boolean hideFragment() {
		return hideFragment(true);
	}

	public final boolean hideFragment(boolean animate) {
		return hideFragment(animate, bottomFragment == null);
	}

	public final boolean hideFragment(boolean animate, boolean mainBack) {
		onFinishSelf();
		if (bottomFragment != null) {
			bottomFragment.popChild(animate);
		}
		hideSelf(animate);
		return mainBack;
	}

	private void hideSelf(boolean animate) {
		FragmentTransaction trans = getActivity().getSupportFragmentManager()
				.beginTransaction();
		if (animate) {
			trans.setCustomAnimations(0,0,0,0);
		}
		trans.hide(this);
		trans.commit();
	}

	private void pushChild(BaseFragment top, boolean animate) {
		onPushChild(top, animate);
		this.topFragment = top;
		top.bottomFragment = this;
	}

	private BaseFragment popChild(boolean animate) {
		BaseFragment ret = topFragment;
		onPopChild(ret, animate);
		topFragment = null;
		return ret;
	}

	protected void onPopChild(BaseFragment deleted, boolean animate) {
	}

	protected void onPushChild(BaseFragment added, boolean animate) {
	}

	protected void onFinishSelf() {
	}

	protected void onShowSelf() {
	}

	protected boolean onAdvancedBackPressed() {
		return false;
	}

	public void onSwipeRightOnce() {

	}

	public void onSwipeLeftOnce() {

	}

	protected final BaseFragment getTop() {
		return topFragment;
	}

	protected final BaseFragment getBottom() {
		return bottomFragment;
	}

	protected final void finishTop() {
		if (topFragment != null) {
			topFragment.hideFragment();
		}
	}

	

	protected final boolean isBackPressed() {
		return this.isBackPressed;
	}
}