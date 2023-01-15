package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class seeModules extends AppCompatActivity {

    ListView seeModules;
    String[] modules = {"Node Server","AI Server","Node Modules","Web Extension"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_modules);

        seeModules = findViewById(R.id.modulesList);


        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,modules);
        seeModules.setAdapter(adapter);

    }
}