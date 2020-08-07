package com.socialfeathers.app;

import java.io.IOException;
import java.util.List;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.core.app.ActivityCompat;


public class GPSProvider {

    // LocationRequest Config Constants
    private static final int MAX_GPS_UPDATE_INTERVAL = 10;
    private static final int FASTEST_GPS_UPDATE_INTERVAL = 2;

    // Geo-coder Config variables
    private static final int MAX_RESULT_FOR_GEOCODE = 1;

    // request code for GPS Permission
    private static final int PERMISSION_REQUEST_CODE_GPS = 101;

    // Get Class Name
    private static String TAG = GPSProvider.class.getName();

    // Context of the activity that called it
    private final Context mContext;

    //GPS call back function
    private static LocationCallback locationCallback;

    // GPS Config File
    private static LocationRequest locationRequest;

    // Google Location API
    private static FusedLocationProviderClient fusedLocationProviderClient;

    // location variables
    public static String address = "hell";
    public static double latitude;
    public static double longitude;

    /**
     * getter for address (reverse geolocation)
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * setter for address (reverse geolocation)
     * @param address set the address (reverse geolocation)
     */
    private static void setAddress(String address) {
        GPSProvider.address = address;
    }

    /**
     * getter for latitude
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * setter for latitude
     * @param latitude latitude of the geolocation co-ordinates
     */
    private void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * getter for longitude
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * setter for longitude
     * @param longitude longitude of the geolocation co-ordinates
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public GPSProvider(Context context) {

        // setting the context
        this.mContext = context;


        //Creating and initialise the location request config object
        locationRequest = new LocationRequest();

        locationRequest.setInterval(1000 * MAX_GPS_UPDATE_INTERVAL);
        locationRequest.setFastestInterval(1000 * FASTEST_GPS_UPDATE_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        // callback function is need if longer duration of GPS data is needed
        locationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                setLocationValues(locationResult.getLastLocation());

            }
        };
    }

    public void startLocationUpdates() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext);

        if (ActivityCompat.checkSelfPermission(mContext,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
        }else{
            Log.e(TAG, "startLocationUpdates: Location permissions not granted");
        }

        getLatestGPSLocation();
    }

    public void stopLocationUpdates() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }


    private void getLatestGPSLocation(){
        if(isGPSOn()) {
//            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext);

            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                fusedLocationProviderClient.getLastLocation().addOnSuccessListener((Activity) mContext, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        setLocationValues(location);
                        Log.e(TAG, "onSuccess: " );
                    }
                });
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestGPSPermission();
                } else {
                    Log.e(TAG, "getLatestGPSLocation: GPS not supported for Build Code (API) less than 23");
                }
            }
        }else{
            turnOnGPS();
        }
    }

    private void turnOnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(R.string.GPS_AlertDialog_Message)
                .setCancelable(false)
                .setPositiveButton(R.string.AlertDialog_Yes, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                       turnOnGPSThroughSettingsIntent();
                    }
                })
                .setNegativeButton(R.string.AlertDialog_No, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * Set location values
     * sets latitude, longitude and address(reverse geo location)
     */
    private void setLocationValues(Location location) {

        // Set Latitude and longitude
        setLatitude(location.getLatitude());
        setLongitude(location.getLongitude());

        Log.e(TAG, "setLocationValues: Lat:"+latitude + ", Long" + longitude);

        // Creating a Geo-coder object to get the reverse geo location
        Geocoder geocoder = new Geocoder(mContext);

        //try to get the reverse geo location
        try{
            /*
             * Create a list of address for geo coder.
             * It may return multiple addresses.
             */
            List<Address> addressList = geocoder.getFromLocation(getLatitude(),getLongitude(), MAX_RESULT_FOR_GEOCODE);
            /*
             * Get the first AddressLine of the first address.
             */
            address = addressList.get(0).getAddressLine(0);

            Log.e(TAG, "setLocationValues: address(reverse geolocation):"+address );

        } catch (IOException e) {
            Log.e(TAG, "setLocationValues: unable to get reverse geo location from Geo-coder.\n" );
        }
    }

    /**
     * Check to see if gps is on on the mobile device.
     * @return true if GPS on, false otherwise.
     */
    private boolean isGPSOn(){
        final LocationManager locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return true;
        }

        return false;
    }

    /**
     * Request GPS Permission.
     */
    private void requestGPSPermission(){
        ActivityCompat.requestPermissions((Activity)mContext, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE_GPS);
    }

    /**
     * Open the Settings page for GPS
     */
    private void turnOnGPSThroughSettingsIntent(){
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        mContext.startActivity(intent);
    }

}