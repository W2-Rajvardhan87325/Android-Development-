package com.sunbeaminfo.app6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        Intent intent = getIntent();
        Employee e = (Employee) intent.getSerializableExtra("employee");
        //TO-DO
        // set all the employee values in the respectiive textviews
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}