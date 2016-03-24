package com.siliconstem.wok.woklib;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SimpleSplashActivity extends BaseActivity {

    private int splashAfterFadeInMiliseconds=2000;
    private int splashAfterFadeOutMiliseconds=2000;
    private int splashFadeInMiliseconds=3000;
    private int splashFadeOutMiliseconds=1000;
    private int splashEndBufferMiliseconds=1000;
    ImageView splashImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actvity_simplesplash);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setStartOffset(0);
        fadeIn.setDuration(this.splashFadeInMiliseconds);
        fadeIn.setInterpolator(new DecelerateInterpolator());


        Animation showSplashImage = new AlphaAnimation(1, 1);
        showSplashImage.setStartOffset(this.splashFadeInMiliseconds);
        showSplashImage.setDuration(this.splashAfterFadeInMiliseconds);
        showSplashImage.setInterpolator(new AccelerateInterpolator());

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(this.splashFadeInMiliseconds+this.splashAfterFadeInMiliseconds);
        fadeOut.setDuration(this.splashFadeOutMiliseconds);
        fadeOut.setInterpolator(new AccelerateInterpolator());

        Animation showBlankImage = new AlphaAnimation(1, 1);
        showBlankImage.setStartOffset(this.splashFadeInMiliseconds+this.splashAfterFadeInMiliseconds+this.splashFadeOutMiliseconds);
        showBlankImage.setDuration(this.splashAfterFadeOutMiliseconds+splashAfterFadeOutMiliseconds);
        showBlankImage.setInterpolator(new AccelerateInterpolator());


        AnimationSet animation = new AnimationSet(false);
        animation.addAnimation(fadeIn);
        animation.addAnimation(showSplashImage);
        animation.addAnimation(fadeOut);
        animation.addAnimation(showBlankImage);


        splashImageView = new ImageView(this);
        splashImageView.setImageResource(R.drawable.splash1);
        splashImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        splashImageView.setLayoutParams(layoutParams);

        splashImageView.startAnimation(animation);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.splashImageLinearLayout);
        //splashImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(splashImageView);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(splashFadeInMiliseconds+splashAfterFadeInMiliseconds+splashFadeOutMiliseconds+splashEndBufferMiliseconds);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SimpleSplashActivity.this,BaseActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }


    @Override
    public void onStart()
    {
        super.onStart();
        l();
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        l();
    }
    @Override
    public void onResume()
    {
        super.onResume();
        l();


    }
    @Override
    public void onPause()
    {
        super.onPause();
        l();
    }
    @Override
    public void onStop()
    {
        super.onStop();
        l();
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        l();
    }

}

