package com.sunbeaminfo.mobilestore.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.utils.Constants;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        imageView.startAnimation(animation);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    // to navigate to the HomeActivity if the user has checked remember me
                    SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME, MODE_PRIVATE);
                    if (preferences.getBoolean(Constants.LOGIN_STATUS, false))
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    else
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}