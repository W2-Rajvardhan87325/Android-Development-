package com.rajvardhan.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class CourseDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView courseName,courseDescp,courseFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_details);

        imageView=findViewById(R.id.courseImage);
        courseName=findViewById(R.id.courseName);
        courseDescp=findViewById(R.id.courseDescp);
        courseFees=findViewById(R.id.courseFees);

        Intent intent=getIntent();
        Course course =(Course) intent.getSerializableExtra("courseDetails");

        imageView.setImageResource(course.getCourseImage());
        courseName.setText(course.getCourseName());
        courseDescp.setText("Course Description : :\n"+course.getCourseDescp());
        courseFees.setText("Course Fees : :\n"+course.getCourseFees());
    }
}