package com.sunbeaminfo.app3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkboxCpp,checkboxJava;
    ImageView imageCpp,imageJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //setContentView(R.layout.activity_main);
//        checkboxCpp = findViewById(R.id.checkboxCpp);
//        checkboxJava = findViewById(R.id.checkboxJava);
//        imageCpp = findViewById(R.id.imageCpp);
//        imageJava = findViewById(R.id.imageJava);

    }

    public void showImages(View view){
        if(checkboxCpp.isChecked())
            imageCpp.setImageResource(R.drawable.cpp);
        else
            imageCpp.setImageResource(R.drawable.ic_launcher_background);
        if(checkboxJava.isChecked())
            imageJava.setImageResource(R.drawable.java);
        else
            imageJava.setImageResource(R.drawable.ic_launcher_background);
    }
}