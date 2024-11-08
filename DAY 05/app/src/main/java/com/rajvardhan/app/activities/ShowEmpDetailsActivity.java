package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Employee;

public class ShowEmpDetailsActivity extends AppCompatActivity {

    TextView empId, empName, empSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_emp_details);

        empId = findViewById(R.id.empId);
        empName = findViewById(R.id.empName);
        empSal = findViewById(R.id.empSal);

        Intent intent = getIntent();
        Employee employee = (Employee) intent.getSerializableExtra("emp");

        empId.setText("Employee Id          : : " + employee.getEmpId());
        empName.setText("Employee Name  : : " + employee.getEmpName());
        empSal.setText("Employee Salary  : : " + employee.getEmpSalary());
    }
}