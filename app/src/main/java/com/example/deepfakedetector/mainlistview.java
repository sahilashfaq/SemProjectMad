package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class mainlistview extends AppCompatActivity {

    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlistview1);
        listView = (ListView) findViewById(R.id.listView1);

        personInfo  person1 = new personInfo("Sahil","3 november","male");
        personInfo  person2 = new personInfo("Ahsan","6 november","male");
        personInfo  person3 = new personInfo("Ayesha","1 november","female");
        personInfo  person4 = new personInfo("Lucy","9 november","female");
        personInfo  person5 = new personInfo("Maria","3 December","female");

        ArrayList<personInfo> peopleList = new ArrayList<>();
        peopleList.add(person1);
        peopleList.add(person2);
        peopleList.add(person3);
        peopleList.add(person4);
        peopleList.add(person5);

        PersonListAdapter adapter = new PersonListAdapter(this,R.layout.activity_custom_list_view,peopleList);
        listView.setAdapter(adapter);
    }
}