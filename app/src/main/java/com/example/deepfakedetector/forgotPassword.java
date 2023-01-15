package com.example.deepfakedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepfakedetector.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    Button forgotPassword;
    TextView enterEmail;
    String email;
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();
        enterEmail = findViewById(R.id.forgetPasswordEmail);
        forgotPassword = findViewById(R.id.forgotPasswordButton);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateEmail();
                }
        });
    }
    public void forgetPassword(){
        mAuth.sendPasswordResetEmail(enterEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    startActivity(new Intent(forgotPassword.this,MainActivity.class));
                    finish();
                    Toast.makeText(forgotPassword.this, "Now Check your email.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(forgotPassword.this, "Enter Correct Email ", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(forgotPassword.this, ""+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        /*mAuth.sendPasswordResetEmail(enterEmail.getText().toString()).addOnSuccessListener(suc->{
            Toast.makeText(forgotPassword.this, "Check your email.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(forgotPassword.this,MainActivity.class));

        }).addOnFailureListener(er->{
            Toast.makeText(forgotPassword.this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();

        });*/
    }

    public void ValidateEmail(){
        email = enterEmail.getText().toString();
        if(email.isEmpty()){
            enterEmail.setError("Email Required!");
        }
        else{
            forgetPassword();
        }
    }

}