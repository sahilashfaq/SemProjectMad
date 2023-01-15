package com.example.deepfakedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity  {

    EditText email,password;
    Button submit;
    String usernameResult,passwordResult;
    TextView openLogin;
    TextView forgetPassword;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    String emailStr,passwordStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgetPassword = findViewById(R.id.forgetPassword);
        email = findViewById(R.id.email);
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
                if(TextUtils.isEmpty(email.getText().toString()))
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

                    /*Intent intent = new Intent(MainActivity.this, LandingPage.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Successfully Logged In.", Toast.LENGTH_LONG).show();*/

                     emailStr = email.getText().toString();
                     passwordStr = password.getText().toString();

                    if(emailStr.isEmpty()){
                        email.setError("Email is required!");
                        email.requestFocus();
                    }
                    else if(passwordStr.isEmpty()){
                        email.setError("Password is required!");
                        password.requestFocus();
                        return;
                    }
                    else if(passwordStr.length()<8){
                        password.setError("Minimum length of password is 8!");
                        password.requestFocus();
                        return;
                    }
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                startActivity(new Intent(MainActivity.this,LandingPage.class));
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

public void openRegistrationPage(){
        Intent intent = new Intent(this,Registration.class);
        startActivity(intent);
}
public void forgetPass(){
    Intent intent = new Intent(this,forgotPassword.class);
    startActivity(intent);
    }
}

