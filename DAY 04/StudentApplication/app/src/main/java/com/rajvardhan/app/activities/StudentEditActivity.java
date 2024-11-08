package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Student;

public class StudentEditActivity extends AppCompatActivity {

    Student obj;
    TextView editRollNo;
    EditText editName,editCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_edit);

        Intent intent=getIntent();
        obj = (Student) intent.getSerializableExtra("student");

        editRollNo=findViewById(R.id.editRollNo);
        editName=findViewById(R.id.editName);
        editCourse=findViewById(R.id.editCourse);

        editRollNo.setText("Student ID : : "+obj.getRollNo());
        editName.setText(obj.getName());
        editCourse.setText(obj.getCourse());
    }

    public void edit(View view) {
        Student tempStd=new Student();
        tempStd.setImage(obj.getImage());
        tempStd.setRollNo(obj.getRollNo());
        tempStd.setName(editName.getText().toString());
        tempStd.setCourse(editCourse.getText().toString());

        Intent intent=new Intent();
        intent.putExtra("student",tempStd);
        setResult(2,intent);
        Toast.makeText(this,"Edited Successfully", Toast.LENGTH_LONG).show();
        finish();
    }

    public void cancel(View view){
        finish();
    }
}