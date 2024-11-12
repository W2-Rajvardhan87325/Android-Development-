package com.sunbeaminfo.app4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Profile");
        menu.add("Settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().equals("Profile")) {
            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
            if(item.getTitle().equals("Settings")) {
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
            }
            return super.onOptionsItemSelected(item);
    }
}