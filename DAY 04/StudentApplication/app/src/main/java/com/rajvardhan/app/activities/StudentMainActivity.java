package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.app.R;
import com.rajvardhan.app.adapters.StudentAdapter;
import com.rajvardhan.app.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMainActivity extends AppCompatActivity {

    List<Student> studentList;
    Toolbar toolbar;
    RecyclerView recyclerView;

    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycleView);

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Rajvardhan Patil", "Diploma in Mobile Computing", R.drawable.raj));
        studentList.add(new Student(2, "Dhanashri Bhosale", "Diploma in Mobile Computing", R.drawable.ic_launcher_background));

        studentAdapter = new StudentAdapter(this, studentList,launcher);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    }

    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==1){
               Student s= (Student)result.getData().getSerializableExtra("student");
               studentList.add(s);
               studentAdapter.notifyDataSetChanged();
            }
            if(result.getResultCode()==2){
                Student s=(Student)result.getData().getSerializableExtra("student");
                studentList.remove(s);
                studentList.add(s);
                studentAdapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Student");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, AddStudentActivity.class);
        launcher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}