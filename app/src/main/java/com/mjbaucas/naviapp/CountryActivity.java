package com.mjbaucas.naviapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Button backBtn = findViewById(R.id.back_country);
        String selContinent = getIntent().getStringExtra("SELECTED_CONTINENT");
        final Button selectBtn = findViewById(R.id.select_country);

        List<String> countries = getCountries(selContinent);
        final Spinner countrySpn = findViewById(R.id.spin_country);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpn.setAdapter(countryAdapter);

        countrySpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectBtn.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectBtn.setEnabled(false);
            }
        });


        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = countrySpn.getSelectedItem().toString();
                String university = getUniversity(country);
                Uri uri = Uri.parse("geo:" + university + "?z=15&q=" + university);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

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
        asiaCont.add("Philippines");
        asiaCont.add("Malaysia");
        asiaCont.add("Japan");
        asiaCont.add("Singapore");

        List<String> europeCont = new ArrayList<>();
        europeCont.add("Great Britain");
        europeCont.add("Belgium");
        europeCont.add("Switzerland");
        europeCont.add("Germany");

        List<String> oceaniaCont = new ArrayList<>();
        oceaniaCont.add("Australia");
        oceaniaCont.add("New Zealand");
        oceaniaCont.add("Papua New Guinea");
        oceaniaCont.add("Fiji");

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

    public String getUniversity(String country){
        switch(country){
            case "Egypt":
                return "30.0576399,31.3151336";
            case "Uganda":
                return "0.329183,32.5709881";
            case "Ghana":
                return "5.650562,-0.1962244";
            case "Kenya":
                return "-1.0465364,37.0851757";
            case "Philippines":
                return "16.3842,120.5932";
            case "Malaysia":
                return "2.9451332,101.8760913";
            case "Japan":
                return "35.0262444,135.7808218";
            case "Singapore":
                return "1.3471791,103.6819423";
            case "Great Britain":
                return "52.2042666,0.1149085";
            case "Belgium":
                return "51.0465619,3.7279181";
            case "Switzerland":
                return "47.3743221,8.5509812";
            case "Germany":
                return "49.4191402,8.6702492";
            case "Australia":
                return "-33.888584,151.1873473";
            case "New Zealand":
                return "-36.8523378,174.7691073";
            case "Papua New Guinea":
                return "-5.2248321,145.7925653";
            case "Fiji":
                return "-18.1499567,178.4440244";
            default:
                return "43.5328929,-80.2262444";
        }
    }
}
