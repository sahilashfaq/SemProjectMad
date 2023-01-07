package com.example.deepfakedetector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<personInfo> {

    Context mcontext;
    int mResource;

    public PersonListAdapter(Context context, int resource, ArrayList <personInfo> objects) {
        super(context, resource, objects);
        mcontext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        String name = getItem(position).getName();
        String birthday = getItem(position).getBirthday();
        String gender = getItem(position).getGender();

        personInfo personInfo = new personInfo(name, birthday, gender);

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView textView1 = convertView.findViewById(R.id.textview1);
        TextView textView2 = convertView.findViewById(R.id.textview2);
        TextView textView3 = convertView.findViewById(R.id.textview3);

        textView1.setText(name);
        textView2.setText(birthday);
        textView3.setText(gender);

        return convertView;
    }
}
