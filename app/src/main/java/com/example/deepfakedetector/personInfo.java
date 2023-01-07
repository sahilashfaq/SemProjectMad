package com.example.deepfakedetector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class personInfo{
    Context context;
    String name;
    String birthday;
    String gender;

    personInfo(String name,String birthday,String gender){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getGender() {
        return gender;
    }
}



