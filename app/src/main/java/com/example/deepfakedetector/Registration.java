package com.example.deepfakedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    TextView SignIn;
    TextView username,email,password;
    Button registerButton;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String emailStr;
    String passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        username = findViewById(R.id.usernameR);
        email = findViewById(R.id.emailR);
        password = findViewById(R.id.passwordR);
        registerButton = findViewById(R.id.submitBtnR);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emailStr = email.getText().toString();
                passwordStr = password.getText().toString();

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
                    //Firebase Authentication
                    mAuth.createUserWithEmailAndPassword(emailStr,passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Registration.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Registration.this,"Registration Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
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
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}