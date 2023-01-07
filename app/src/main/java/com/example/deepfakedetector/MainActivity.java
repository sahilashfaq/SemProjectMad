package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    EditText username,password;
    Button submit;
    String usernameResult,passwordResult;
    TextView openLogin;
    TextView forgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgetPassword = findViewById(R.id.forgetPassword);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submitBtn);
        openLogin = findViewById(R.id.footer);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPass();
            }
        });

        openLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrationPage();
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(username.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Empty fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    /*Intent intent = new Intent(MainActivity.this, RecieverActivity.class);
                    usernameResult = username.getText().toString();
                    intent.putExtra("value1",usernameResult);

                    passwordResult = password.getText().toString();
                    intent.putExtra("value2",passwordResult);

                    startActivity(intent);*/

                    Intent intent = new Intent(MainActivity.this, LandingPage.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Successfully Logged In.", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

public void openRegistrationPage(){
        Intent intent = new Intent(this,Registration.class);
        startActivity(intent);
}
public void forgetPass(){
    Intent intent = new Intent(this,ResetPassword.class);
    startActivity(intent);
    }
}

