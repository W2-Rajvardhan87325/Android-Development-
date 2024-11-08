package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Employee;

public class EditEmployeeActivity extends AppCompatActivity {
    Employee obj;
    TextView editEmpId;
    EditText editEmpName,editEmpSal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        Intent intent=getIntent();
        obj = (Employee) intent.getSerializableExtra("emp");

        editEmpId=findViewById(R.id.editEmpId);
        editEmpName=findViewById(R.id.editEmpName);
        editEmpSal=findViewById(R.id.editEmpSal);

        editEmpId.setText("Employee ID : : "+obj.getEmpId());
        editEmpName.setText(obj.getEmpName());
        editEmpSal.setText(""+obj.getEmpSalary());
    }

    public void edit(View view) {
        Employee tempEmp = new Employee();
        tempEmp.setEmpId(obj.getEmpId());
        tempEmp.setEmpName(editEmpName.getText().toString());
        tempEmp.setEmpSalary(Double.parseDouble(editEmpSal.getText().toString()));

        Intent intent=new Intent();
        intent.putExtra("emp",tempEmp);
        setResult(2,intent);
        Toast.makeText(this,"Edited Successfully", Toast.LENGTH_LONG).show();
        finish();
    }

    public void cancel(View view){
        finish();
    }

}