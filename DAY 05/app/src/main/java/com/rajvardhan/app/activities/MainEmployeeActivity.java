package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
import com.rajvardhan.app.adapters.EmployeeAdapter;
import com.rajvardhan.app.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainEmployeeActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    List<Employee> employeeList = new ArrayList<>();
    EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_employee);

        employeeList.add(new Employee(101, "Rajvardhan Patil", 75000.0));
        employeeList.add(new Employee(102, "Ananya Sharma", 68000.0));
        employeeList.add(new Employee(103, "Amitabh Mishra", 82000.0));
        employeeList.add(new Employee(104, "Priya Kaur", 72000.0));
        employeeList.add(new Employee(105, "Rakesh Nair", 70000.0));

        recyclerView = findViewById(R.id.recycleView);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        employeeAdapter = new EmployeeAdapter(this, employeeList, launcher);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    }

    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 1) {
                Employee s = (Employee) result.getData().getSerializableExtra("emp");
                employeeList.add(s);
                employeeAdapter.notifyDataSetChanged();
            }
            if(result.getResultCode() == 2){
                Employee e = (Employee) result.getData().getSerializableExtra("emp");
                employeeList.remove(e);
                employeeList.add(e);
                employeeAdapter.notifyDataSetChanged();
            }
        }
    });

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Employee");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, AddEmployeeActivity.class);
        launcher.launch(intent);
        return super.onOptionsItemSelected(item);
    }
}