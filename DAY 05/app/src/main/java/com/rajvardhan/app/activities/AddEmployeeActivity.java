package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Employee;

public class AddEmployeeActivity extends AppCompatActivity {
    EditText addEmpId, addEmpName, addEmpSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        addEmpId = findViewById(R.id.addEmpId);
        addEmpName = findViewById(R.id.addEmpName);
        addEmpSal = findViewById(R.id.addEmpSal);
    }

    public void save(View view) {
        Employee employee = new Employee();
        employee.setEmpId(Integer.parseInt(addEmpId.getText().toString()));
        employee.setEmpName(addEmpName.getText().toString());
        employee.setEmpSalary(Double.parseDouble(addEmpSal.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("emp", employee);
        setResult(1, intent);
        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void cancel(View view) {
        finish();
    }

}