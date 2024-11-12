package com.sunbeaminfo.app2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeatilsActivity extends AppCompatActivity {
    TextView textName, textEmail,textEmpid,textSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatils);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textEmpid = findViewById(R.id.textEmpid);
        textSalary = findViewById(R.id.textSalary);

        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String email = intent.getStringExtra("email");
//        textName.setText(name);
//        textEmail.setText(email);

        Employee e = (Employee) intent.getSerializableExtra("emp");
        textEmpid.setText("id - "+e.getEmpId());
        textName.setText(e.getName());
        textEmail.setText(e.getEmail());
        textSalary.setText("Sal - "+e.getSalary());
    }
}