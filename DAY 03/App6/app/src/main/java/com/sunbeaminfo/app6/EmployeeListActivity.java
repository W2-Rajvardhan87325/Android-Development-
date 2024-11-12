package com.sunbeaminfo.app6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {
    ListView listView;
    List<Employee> empList;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        listView = findViewById(R.id.listView);
        empList = new ArrayList<>();
        empList.add(new Employee(1,"Anil",10000));
        empList.add(new Employee(2,"Mukesh",20000));
        empList.add(new Employee(3,"Ramesh",30000));
        empList.add(new Employee(4,"Suresh",40000));
        empList.add(new Employee(5,"Ram",50000));
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,empList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee e = empList.get(position);
                Intent intent = new Intent(EmployeeListActivity.this, EmployeeDetailsActivity.class);
                intent.putExtra("employee",e);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(EmployeeListActivity.this,view);
                popupMenu.getMenu().add("delete");
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(EmployeeListActivity.this, "delete clicked", Toast.LENGTH_SHORT).show();
                        empList.remove(position);
                        adapter.notifyDataSetChanged(); // list refresh
                        return false;
                    }
                });
                return false;
            }
        });

    }
}