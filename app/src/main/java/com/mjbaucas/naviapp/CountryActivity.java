package com.mjbaucas.naviapp;

import android.content.Intent;
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
                Intent universityIntent = new Intent(CountryActivity.this, UniversityActivity.class);
                universityIntent.putExtra("SELECTED_COUNTRY", country);
                startActivity(universityIntent);
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
}
