package com.mjbaucas.naviapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Button backBtn = findViewById(R.id.back_country);

        String selContinent = getIntent().getStringExtra("SELECTED_CONTINENT");
        List<String> countryList = getCountries(selContinent);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public List<String> getCountries(String continent){
        List<String> africaCont = new ArrayList<>();
        africaCont.add("Egypt");
        africaCont.add("Uganda");
        africaCont.add("Ghana");
        africaCont.add("Kenya");

        List<String> asiaCont = new ArrayList<>();
        africaCont.add("Philippines");
        africaCont.add("South Korea");
        africaCont.add("Japan");
        africaCont.add("Singapore");

        List<String> europeCont = new ArrayList<>();
        africaCont.add("Great Britain");
        africaCont.add("Belgium");
        africaCont.add("Switzerland");
        africaCont.add("Germany");

        List<String> oceaniaCont = new ArrayList<>();
        africaCont.add("Australia");
        africaCont.add("New Zealand");
        africaCont.add("Papua New Guinea");
        africaCont.add("Fiji");

        switch(continent) {
            case "Africa":
                return africaCont;
            case "Asia":
                return asiaCont;
            case "Europe":
                return europeCont;
            case "Oceania":
                return oceaniaCont;
            default:
                return africaCont;
        }
    }
}
