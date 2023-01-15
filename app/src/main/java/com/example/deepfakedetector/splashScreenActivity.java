package com.example.deepfakedetector;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashScreenActivity extends AppCompatActivity {
    ImageView logo;
    TextView title;
    TextView module;
    Animation top;
    Animation bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo = (ImageView) findViewById(R.id.logo);
        title = (TextView) findViewById(R.id.title);
        module = (TextView) findViewById(R.id.module);


        top = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        logo.setAnimation(top);
        title.setAnimation(bottom);
        module.setAnimation(bottom);


        Thread thread1 = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(splashScreenActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread1.start();

    }
}