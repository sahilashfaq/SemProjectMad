package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class forgotPassword extends AppCompatActivity {

    Button forgotPassword;
    TextView enterEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        enterEmail = findViewById(R.id.enterEmail);
        forgotPassword = findViewById(R.id.forgotPasswordButton);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(enterEmail.getText().toString()))
                {
                    Toast.makeText(forgotPassword.this, "Please enter your Email!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    forgetPassword();
                }
            }
        });
    }
    public void forgetPassword(){
        Intent intent = new Intent(this,ResetPassword.class);
        startActivity(intent);
    }
}