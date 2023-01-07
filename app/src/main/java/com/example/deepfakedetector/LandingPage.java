package com.example.deepfakedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.util.zip.Inflater;

public class LandingPage extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    TextView seeDetails;
    TextView TextViewForContextMenu;
    Button popupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        TextViewForContextMenu = findViewById(R.id.TextViewForContextMenu);
        registerForContextMenu(TextViewForContextMenu);

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
    }
    public void gotoSeeDetails(){
        Intent intent = new Intent(this,mainlistview.class);
        startActivity(intent);
    }
}