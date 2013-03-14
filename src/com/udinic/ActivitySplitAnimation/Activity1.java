package com.udinic.ActivitySplitAnimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.udinic.ActivitySplitAnimation.utils.ActivitySplitAnimationUtil;

public class Activity1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_one);

        findViewById(R.id.one).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitySplitAnimationUtil.startActivity(Activity1.this, new Intent(Activity1.this, Activity2.class));
            }
        });
    }
}
