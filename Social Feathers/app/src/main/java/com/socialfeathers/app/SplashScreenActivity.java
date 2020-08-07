package com.socialfeathers.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;


public class SplashScreenActivity extends AppCompatActivity {

    private static final int PERMISSION_CODE_GPS_FINE = 101;
    final int delay = 1000;          //delay time to start next activity.

    static ImageView logoView;//logo ImageView
    

    LocationCallback locationCallback;

    // GPS Config File
    LocationRequest locationRequest;

    // Google Location API
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //check the logo image view
        logoView = findViewById(R.id.splashScreenLogoView);
        assert logoView != null;

//        // getting screen height and width
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int screenHeight = displayMetrics.heightPixels;
//        int screenWidth = displayMetrics.widthPixels;

        ScreenSizeProvider screenSize= new ScreenSizeProvider(this);
        int screenWidth = screenSize.getScreenWidth();
        int screenHeight = screenSize.getScreenHeight();

        //setting logo height and width
//        logoView.getLayoutParams().height = screenHeight * 3 / 4;
        logoView.getLayoutParams().width = screenWidth * 3 / 4;


        final GPSProvider gps = new GPSProvider(this);

        gps.startLocationUpdates();

        // move to home screen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                /* TODO remove
                *
                 */
                gps.stopLocationUpdates();

                Intent homeActivity = new Intent(SplashScreenActivity.this,HomeActivity.class);
                startActivity(homeActivity);
                finish();
            }
        }, delay);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_CODE_GPS_FINE:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    updateGPS();
                }
                else{
                    Toast.makeText(this, "This APP Needs permission please grant location permissions" , Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;

        }
    }
}