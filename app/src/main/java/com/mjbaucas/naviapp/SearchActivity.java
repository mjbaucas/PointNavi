package com.mjbaucas.naviapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button backBtn = findViewById(R.id.back_search);
        Button searchBtn = findViewById(R.id.search_search);

        final EditText latInput =  findViewById(R.id.input_latitude);
        final EditText longInput =  findViewById(R.id.input_longitude);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                String latVal = latInput.getText().toString();
                String longVal = longInput.getText().toString();

                Uri uri = Uri.parse("geo:" + latVal + "," + longVal + "?z=14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }




}