package com.rajvardhan.app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<Course> courseList;
    RecyclerView recyclerView;

    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        courseList = new ArrayList<>();

        courseList.add(new Course(1, "Diploma In Advance Computing", "The course aims to groom the students to enable them to work on current technology scenarios as well as prepare them to keep pace with the changing face of technology and the requirements of the growing IT industry.", 90000.0, R.drawable.dac));
        courseList.add(new Course(2, "Diploma In Mobile Computing", "The main focus of this course is to enable the candidates fulfilling the eligibility criteria, to develop their skill set mainly in areas like Native and Hybrid Mobile Application Development.", 100000.0, R.drawable.dmc));
        courseList.add(new Course(3, "Diploma In Embedded Systems Design", "Embedded Systems is a unique field, where engineers need to have sound knowledge in hardware and software design.", 90000.0, R.drawable.desd));
        courseList.add(new Course(4, "Diploma In Big Data Analytics", "The course is also suitable for those who are already working in analytics to enhance their theoretical and conceptual knowledge as well as those with analytical aptitude and would like to start career in big data analytics in different business sectors.", 115000.0, R.drawable.dbda));
        courseList.add(new Course(5, "Diploma In IT Infrastructure, Systems and Security", "To understand the Concepts of Data Centre Management, applications security implementation and use various techniques for Ethical Hacking and Cyber Forensics.", 90000.0, R.drawable.ditiss));

        recyclerView = findViewById(R.id.recyclerView);

        courseAdapter=new CourseAdapter(this,courseList);
        recyclerView.setAdapter(courseAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
}