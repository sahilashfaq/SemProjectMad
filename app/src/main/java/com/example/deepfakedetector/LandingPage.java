package com.example.deepfakedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepfakedetector.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarItemView;

import java.util.zip.Inflater;

public class LandingPage extends AppCompatActivity{

    TextView seeDetails;
    TextView TextViewForContextMenu;
    Button showContactUsPageBtn;
    TextView seeModules,showContactUsPage;
    ActivityMainBinding binding;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        showContactUsPageBtn = findViewById(R.id.showContactUsPageBtn);
        showContactUsPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSeeContactUs();
            }
        });

        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavigationBarItemView navigationBarItemView = findViewById(R.id.BottomNavigationView);
        navigationBarItemView.setOnClickListener(item->{
            switch (item.getId()){
                case R.id.homeID:
                    replaceFragment(new ContactusFragment());
                    break;
                case R.id.settingID:
                    break;
                case R.id.profileID:
                    break;
            }
        });

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

       /* seeModules = findViewById(R.id.seeModules);
        seeModules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seeModulesMethod();
            }
        });

        // Context Menu
        TextViewForContextMenu = findViewById(R.id.TextViewForContextMenu);
        registerForContextMenu(TextViewForContextMenu);

        // Popup Button
        popupButton = findViewById(R.id.popUpButton);

        seeDetails = findViewById(R.id.seeDetails);
        seeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSeeDetails();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ContextMenuItem1:
                Toast.makeText(this,"Item 1 Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ContextMenuItem2:
                Toast.makeText(this,"Item 2 Selected",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    // popup menu
    public void showPopUp(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popupmenu);
        popupMenu.show();
    }

    // Method for Pop up menu items
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.popupitem1:
                Toast.makeText(this,"Item 1 selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupitem2:
                Toast.makeText(this,"Item 2 selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupitem3:
                Toast.makeText(this,"Item 3 selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.popupitem4:
                Toast.makeText(this,"Item 4 selected",Toast.LENGTH_SHORT).show();
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item 1 Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this,"Item 2 Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this,"Item 3 Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Toast.makeText(this,"Item 4 Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this,"subitem 1 Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this,"subitem 2 Selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        showContactUsPage = findViewById(R.id.showContactUsPage);
        showContactUsPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this,ContactUs.class));
            }
        });*/
    }
    public void seeModulesMethod(){
        Intent intent = new Intent(this,seeModules.class);
        startActivity(intent);
    }
    public void gotoSeeDetails(){
        Intent intent = new Intent(this,mainlistview.class);
        startActivity(intent);
    }

    public void gotoSeeContactUs(){
        Intent intent = new Intent(this,ContactUs.class);
        startActivity(intent);
    }
    /*public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }*/
}