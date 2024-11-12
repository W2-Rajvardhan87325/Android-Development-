package com.sunbeaminfo.app1;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main2);
//        setContentView(R.layout.activity_main3);
        setContentView(R.layout.activity_main4);
        Log.e("MainActivity","onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity","OnStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity","OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity","OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity","OnDestroy()");
    }
}