package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Student;

public class AddStudentActivity extends AppCompatActivity {

    EditText addRollNo, addName, addCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        addRollNo = findViewById(R.id.addRollNo);
        addName = findViewById(R.id.addName);
        addCourse = findViewById(R.id.addCourse);

    }

    public void save(View view) {
        Student student = new Student();
        student.setRollNo(Integer.parseInt(addRollNo.getText().toString()));
        student.setName(addName.getText().toString());
        student.setCourse((addCourse.getText().toString()));

        Intent intent = new Intent();
        intent.putExtra("student", student);
        setResult(1, intent);
        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void cancel() {
        finish();
    }
}