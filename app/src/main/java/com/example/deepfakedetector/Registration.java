package com.example.deepfakedetector;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    TextView SignIn;
    TextView username,email,password;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
       // getSupportActionBar().setCustomView(R.layout.activity_registration);

        username = findViewById(R.id.usernameR);
        email = findViewById(R.id.emailR);
        password = findViewById(R.id.passwordR);
        registerButton = findViewById(R.id.submitBtnR);
        DAOUser dao = new DAOUser();
        
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(username.getText().toString()))
                {
                    Toast.makeText(Registration.this, "Please enter username.", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password.getText().toString()))
                {
                    Toast.makeText(Registration.this, "Please enter your password.", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(email.getText().toString()))
                {
                    Toast.makeText(Registration.this, "Please enter your Email.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    user newUser = new user(username.getText().toString(),email.getText().toString(),password.getText().toString());
                    dao.add(newUser).addOnSuccessListener(suc->{
                        Toast.makeText(Registration.this, "Successfully Registered.", Toast.LENGTH_SHORT).show();
                        gotoLogin();

                    }).addOnFailureListener(er->{
                        Toast.makeText(Registration.this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();

                    });
                    //gotoLogin();
                    //Toast.makeText(Registration.this, "Account Created! Now Login your account.", Toast.LENGTH_LONG).show();
                }
            }
        });

        SignIn = findViewById(R.id.gotoRegistration);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { gotoLogin(); }
        });
    }
    public void gotoLogin(){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
    }
}