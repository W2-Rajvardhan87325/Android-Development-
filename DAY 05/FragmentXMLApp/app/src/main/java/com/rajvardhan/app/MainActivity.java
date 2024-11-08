package com.rajvardhan.app;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.rajvardhan.app.Fragments.FirstFragment;
import com.rajvardhan.app.Fragments.SecondFragment;
import com.rajvardhan.app.Fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadFirstFrag(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, new FirstFragment())
                .commit();
    }

    public void loadSecondFrag(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, new SecondFragment())
                .commit();
    }

    public void loadThirdFrag(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, new ThirdFragment())
                .commit();
    }
}
