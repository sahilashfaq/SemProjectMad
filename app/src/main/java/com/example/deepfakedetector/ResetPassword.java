package com.example.deepfakedetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    TextView gotoSignIn;
    TextView gotoSignUp;
    TextView newPassword, verifyPassword;
    Button resetButton;
    String storeNewPassword, storeVerifyPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        
        newPassword = findViewById(R.id.newPassword);
        verifyPassword = findViewById(R.id.Verifypassword);
        storeNewPassword = newPassword.getText().toString();
        storeVerifyPassword = verifyPassword.getText().toString();
        
        resetButton = findViewById(R.id.changePasswordBtn);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(storeNewPassword == storeVerifyPassword)
                {
                    SignIn();
                }
                else{
                    Toast.makeText(ResetPassword.this, "New Password and Verfiy Password are not same!", Toast.LENGTH_LONG).show();
                }
            }
        });

       // gotoSignIn = findViewById(R.id.gotoSignIn);
       // gotoSignUp = findViewById(R.id.gotoSignUp);

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