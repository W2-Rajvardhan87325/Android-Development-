package com.sunbeaminfo.app4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPhone = findViewById(R.id.editPhone);
    }

    // Implicit Intent
    public void call(View view){
        String phone = editPhone.getText().toString();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:8983049388"));
        intent.setData(Uri.parse("tel:"+phone));
        startActivity(intent);

    }

    public void browse(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://sunbeaminfo.com/placements"));
        startActivity(intent);
    }
}