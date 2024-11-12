package com.sunbeaminfo.app2;

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
    EditText editName,editEmail,editEmpid,editSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editEmpid = findViewById(R.id.editEmpid);
        editSalary = findViewById(R.id.editSalary);
    }

    public void save(View v){
        Employee e = new Employee();
        e.setEmpId(Integer.parseInt(editEmpid.getText().toString()));
        e.setName(editName.getText().toString());
        e.setEmail(editEmail.getText().toString());
        e.setSalary(Double.parseDouble(editSalary.getText().toString()));

        Intent intent = new Intent(this, DeatilsActivity.class);
        intent.putExtra("emp",e);
        startActivity(intent);
    }

//    public void save(View v){
//        String name = editName.getText().toString();
//        String email = editEmail.getText().toString();
//        Intent intent = new Intent(this, DeatilsActivity.class);
//        intent.putExtra("name",name);
//        intent.putExtra("email",email);
//        startActivity(intent);
//        editName.setText("");
//        editEmail.setText("");
//    }
}