package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class RecieverActivity extends AppCompatActivity {

    TextView username,password;
    String usernameResult,pwdResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);

        username = findViewById(R.id.displayUsername);
        usernameResult = getIntent().getExtras().getString("value1");
        username.setText("Username: "+usernameResult);

        password = findViewById(R.id.displayPwd);
        pwdResult = getIntent().getExtras().getString("value2");
        password.setText("Password: "+pwdResult);
    }
}