package com.example.socialfeathers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    final int delay = 9000;          //delay time to start next activity.

    static ImageView logoView;      //logo ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //check the logo image view
        logoView = findViewById(R.id.splashScreenLogoView);
        assert logoView != null;

        // getting screen height and width
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;
        int screenWidth = displayMetrics.widthPixels;

        //setting logo height and width
        logoView.getLayoutParams().height = screenWidth/2;
        logoView.getLayoutParams().width = screenWidth/2;


        // move to home screen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeActivity = new Intent(SplashScreenActivity.this,HomeActivity.class);
                startActivity(homeActivity);
                finish();
            }
        }, delay);
    }
}