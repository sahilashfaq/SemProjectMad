package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        String[] months = {"January", "February", "March", "April","May","June"};
        ArrayAdapter <String> adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,months);
       // listView =  findViewById(R.id.listView1);
        listView.setAdapter(adapter);


        }
}