package com.socialfeathers.app;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenSizeProvider {

    private static final DisplayMetrics displayMetrics = new DisplayMetrics();

    private Activity myActivity;        // Activity in Use

    public ScreenSizeProvider(Activity myActivity){

        this.myActivity = myActivity;

        // initialise display metrics variable
        myActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

    }

    public int getScreenHeight() {
        return displayMetrics.heightPixels;
    }

    public int getScreenWidth() {
        return displayMetrics.widthPixels;
    }

}
