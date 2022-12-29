package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResetPassword extends AppCompatActivity {

    TextView gotoSignIn;
    TextView gotoSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        gotoSignIn = findViewById(R.id.gotoSignIn);
        gotoSignUp = findViewById(R.id.gotoSignUp);

        gotoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });

        gotoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });
    }
public void SignIn(){
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);
}
public void SignUp(){
    Intent intent = new Intent(this,Registration.class);
    startActivity(intent);
}
}