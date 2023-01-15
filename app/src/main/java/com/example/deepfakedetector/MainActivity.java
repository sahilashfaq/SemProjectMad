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
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity  {

    EditText email,password;
    Button submit;
    String usernameResult,passwordResult;
    TextView openLogin;
    TextView forgetPassword;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
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
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

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

                //Validations
                if(TextUtils.isEmpty(email.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Empty fields not allowed", Toast.LENGTH_SHORT).show();
                }
                else
                {

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
                    //Firebase Authentication
                    mAuth.signInWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                isLandingPage();
                                Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });
    }

    private void isLandingPage() {
        Intent intent = new Intent(this,LandingPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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

