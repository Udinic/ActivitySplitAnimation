package com.udinic.ActivitySplitAnimation;

import android.app.Activity;
import android.os.Bundle;
import com.udinic.ActivitySplitAnimation.utils.ActivitySplitAnimationUtil;

/**
 * Created with IntelliJ IDEA.
 * User: Udini
 * Date: 12/03/13
 * Time: 15:18
 */
public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Preparing the 2 images to be split
        ActivitySplitAnimationUtil.prepareAnimation(this);

        setContentView(R.layout.act_two);

        // Animating the items to be open, revealing the new activity
        ActivitySplitAnimationUtil.animate(this, 1000);
    }

    @Override
    protected void onStop() {
        // If we're currently running the entrance animation - cancel it
        ActivitySplitAnimationUtil.cancel();

        super.onStop();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
