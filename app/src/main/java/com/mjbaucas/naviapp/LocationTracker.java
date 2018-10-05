package com.mjbaucas.naviapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;


public class LocationTracker implements LocationListener {
    double latitude;
    double longitude;
    boolean onGPS = false;

    public void updateLocation(final Activity activity, LocationManager locationManager){
        if(ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, this);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null){
                    longitude = location.getLongitude();
                    latitude = location.getLatitude();
                    onGPS = true;
                } else {
                    onGPS = false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("We cant find you...");  // GPS not found
                    builder.setMessage("GPS has just been turned on and needs time to calibrate. Please try again in a couple of minutes")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            }).setCancelable(false);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            } else {
                onGPS = false;
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("GPS not Found");  // GPS not found
                builder.setMessage("Do you want to enable?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent searchIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            activity.startActivity(searchIntent);
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    }).setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }
    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isOnGPS() {
        return onGPS;
    }
}
