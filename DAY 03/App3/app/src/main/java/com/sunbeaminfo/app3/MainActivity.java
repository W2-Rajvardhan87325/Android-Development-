package com.sunbeaminfo.app3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editEmpid,editName,editEmail,editSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        editEmpid = findViewById(R.id.editEmpid);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editSalary = findViewById(R.id.editSalary);
    }
    public void save(View v){
        Employee e = new Employee();
        e.setEmpid(Integer.parseInt(editEmpid.getText().toString()));
        e.setName(editName.getText().toString());
        e.setEmail(editEmail.getText().toString());
        e.setSalary(Double.parseDouble(editSalary.getText().toString()));
        Intent intent = new Intent();
        intent.putExtra("employee",e);
        setResult(0,intent);
        finish();
    }
}