package com.sunbeaminfo.app2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    List<String> countries;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinner);
        countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("UK");
        countries.add("China");
        countries.add("Japan");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,countries);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Log.e("Spinner","position - "+position);
                //Log.e("Spinner","Value - "+countries.get(position));
                //Toast.makeText(SpinnerActivity.this, "country selected - "+countries.get(position), Toast.LENGTH_SHORT).show();
                //Snackbar.make(SpinnerActivity.this, view,"country selected - "+countries.get(position) ,Snackbar.LENGTH_SHORT).show();
                Snackbar.make(SpinnerActivity.this, view,"country selected - "+countries.get(position) ,Snackbar.LENGTH_SHORT)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SpinnerActivity.this, "undo clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}