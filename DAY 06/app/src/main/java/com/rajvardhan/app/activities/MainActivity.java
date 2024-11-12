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
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rajvardhan.app.R;
import com.rajvardhan.app.adapter.FragmentAdapter;
import com.rajvardhan.app.entities.Employee;
import com.rajvardhan.app.fragments.EmployeeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        fragmentAdapter = new FragmentAdapter(this);
        viewPager2.setAdapter(fragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0:
                        tab.setText("Employees").setIcon(R.drawable.employee);
                        break;
                    case 1:
                        tab.setText("Countries").setIcon(R.drawable.country);
                }
            }
        }).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add Employee");
        menu.add("Add Country");
        return super.onCreateOptionsMenu(menu);
    }
    ActivityResultLauncher launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==1){
                Employee emp=(Employee) result.getData().getSerializableExtra("emp");
                EmployeeFragment employeeFragment=new EmployeeFragment();
                employeeFragment.addEmployee(emp);
            }
        }
    });
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Add Employee")) {
            Intent intent = new Intent(this, AddEmployeeActivity.class);
            launcher.launch(intent);
        }

        if (item.getTitle().equals("Add Country")) {
            Intent intent = new Intent(this, AddCountryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}