package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {

    ImageView logo, splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.shahashh); // Assign the result of findViewById to logo
        splashImg = findViewById(R.id.lotties); // Assign the result of findViewById to splashImg

        logo.animate().translationY(-1600).setDuration(1000).setStartDelay(4000).withEndAction(new Runnable() {
            @Override
            public void run() {
                // Animation is completed, start MainActivity
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);

                // Finish the current activity
                finish();
            }
        });

        splashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
    }
}
