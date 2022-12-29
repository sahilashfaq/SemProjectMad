package com.example.deepfakedetector;

import static com.example.deepfakedetector.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class spinner extends AppCompatActivity {
    Spinner spinner;
    String sports[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_spinner);
        sports = getResources().getStringArray(array.sports_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,sports);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

    }
}