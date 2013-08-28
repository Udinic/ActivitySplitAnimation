package com.udinic.ActivitySplitAnimation;

import android.app.Activity;
import android.os.Bundle;
import com.udinic.ActivitySplitAnimation.utils.ActivitySplitAnimationUtil;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
	// Get intent information for the split animation
	Intent i = getIntent();
	boolean animate = i.getBooleanExtra("doSplitAnimation", false);
	
	// Once the doSplitAnimation extra has been read, we remoe it from intent so
	// that the animation doesn't occur or other instances of onCreate() being
	// called such as rotation.
	if (i.hasExtra("doSplitAnimation"))
		i.removeExtra("doSplitAnimation");

	// Use split animation on if onCreate() is called from other activity. This
	// is to counter the case of this onCreate being called when there is a
	// rotation.
	if (animate)
	    	// Preparing the 2 images to be split
		ActivitySplitAnimationUtil.prepareAnimation(this);

        setContentView(R.layout.act_two);

	// Use split animation on if onCreate() is called from other activity. This
	// is to counter the case of this onCreate being called when there is a
	// rotation.
	if (animate)
		// Animating the items to be open, revealing the new activity, with
    		// the animation duration as 1 sec.
    		ActivitySplitAnimationUtil.animate(this, 1000);
    }

    @Override
    protected void onStop() {
        // If we're currently running the entrance animation - cancel it
        ActivitySplitAnimationUtil.cancel();

        super.onStop();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
