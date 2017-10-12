package com.example.ryantyrrell.battledots_singleplayer;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.ryantyrrell.battledots_singleplayer.R;

/**
 * Created by Ryan Tyrrell on 2016-08-21.
 */
public class Animations {

    Animation starter_timer_animation;

    public Animations(Context context)     {

        starter_timer_animation = AnimationUtils.loadAnimation(context, R.anim.scale_up_and_fade);

    }

    public void animateStartTimer(View view){
        starter_timer_animation.setDuration(1000);
        view.startAnimation(starter_timer_animation);
    }

}
