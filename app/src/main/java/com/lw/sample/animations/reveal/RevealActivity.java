package com.lw.sample.animations.reveal;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.lw.sample.R;

/**
 * Created by yjwfn on 16-3-15.
 */
public class RevealActivity extends AppCompatActivity {

    private View    mRevealView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reveal);

        mRevealView  =  findViewById(R.id.fl_reveal);
    }

    public void hiding(View view) {
        reveal(false);

    }

    public void showing(View view) {
        reveal(true);
    }


    private void reveal(boolean showing){

        int cx = mRevealView.getWidth() / 2;
        int cy = mRevealView.getHeight() / 2;


        float finalRadius = (float) Math.hypot(cx, cy);

        Animator anim = null;


        if(showing) {
            anim  = ViewAnimationUtils.createCircularReveal(mRevealView, 0, 0, 0, finalRadius);
            mRevealView.setVisibility(View.VISIBLE);
        }else{
            anim  = ViewAnimationUtils.createCircularReveal(mRevealView, 0, 0, finalRadius, 0);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mRevealView.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }


        anim.start();
    }
}
