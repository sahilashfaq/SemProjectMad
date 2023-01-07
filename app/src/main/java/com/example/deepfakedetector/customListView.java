package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class customListView extends AppCompatActivity {

    ListView listView;
    String[] cities = {"Rwp", "Islamabad", "GujarKhan", "Lahore","Karachi","Peshawar"};
    int images[] = {R.drawable.email,R.drawable.fb,R.drawable.email,R.drawable.fb,R.drawable.email};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
    }

}