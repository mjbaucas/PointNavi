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

public class ContinentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent);

        Button backBtn = findViewById(R.id.back_continent);
        final Spinner contSpin = findViewById(R.id.spin_continent);
        Button selectBtn = findViewById(R.id.select_continent);

        List<String> continents = new ArrayList<>();
        continents.add("Africa");
        continents.add("Asia");
        continents.add("Europe");
        continents.add("Oceania");

        ArrayAdapter<String> contAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, continents);
        contAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        contSpin.setAdapter(contAdapter);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String continent = contSpin.getSelectedItem().toString();
                Intent countryIntent = new Intent(ContinentActivity.this, CountryActivity.class);
                countryIntent.putExtra("SELECTED_CONTINENT", continent);
                startActivity(countryIntent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
