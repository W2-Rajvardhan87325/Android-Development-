package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.entities.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView rollNo, name, course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        image = findViewById(R.id.image);
        rollNo = findViewById(R.id.rollNo);
        name = findViewById(R.id.name);
        course = findViewById(R.id.course);

        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("student");

        image.setImageResource(student.getImage());
        rollNo.setText("Student Roll       : : " + student.getRollNo());
        name.setText("Student Name   : : " + student.getName());
        course.setText("Studetn Course : : " + student.getCourse());

    }
}