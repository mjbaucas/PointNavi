package com.mjbaucas.naviapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button currBtn = findViewById(R.id.current);
        Button searchBtn = findViewById(R.id.search);
        Button uniBtn = findViewById(R.id.university);
        Button exitBtn = findViewById(R.id.exit_app);

        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final LocationTracker locationTracker = new LocationTracker();


        currBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationTracker.updateLocation(MainActivity.this, locationManager);
                if (locationTracker.isOnGPS()){
                    openMap(locationTracker.getLatitude(), locationTracker.getLongitude());
                }
          }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });

        uniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(MainActivity.this, ContinentActivity.class);
                startActivity(searchIntent);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    })
                    .setCancelable(false);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void openMap(double latitude, double longitude){
        Uri uri = Uri.parse("geo:" + latitude + "," + longitude + "?z=16");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
