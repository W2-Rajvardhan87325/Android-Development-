package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Employee;


public class AddEmployeeActivity extends AppCompatActivity {
    EditText addEmpId,addEmpName,addEmpSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        addEmpId=findViewById(R.id.addEmpId);
        addEmpName=findViewById(R.id.addEmpName);
        addEmpSal=findViewById(R.id.addEmpSal);
    }

    public void save(View view){
        Employee emp=new Employee();
        emp.setEmpId(Integer.parseInt(addEmpId.getText().toString()));
        emp.setEmpName(addEmpName.getText().toString());
        emp.setEmpSalary(Double.parseDouble(addEmpSal.getText().toString()));

        Intent intent=new Intent();
        intent.putExtra("emp",emp);
        setResult(1,intent);
        finish();
    }

    public void cancel(View view){
        finish();
    }
}