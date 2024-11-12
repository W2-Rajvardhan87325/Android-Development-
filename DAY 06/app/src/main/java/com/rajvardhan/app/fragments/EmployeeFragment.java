package com.rajvardhan.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.app.R;
import com.rajvardhan.app.adapter.EmployeeAdapter;
import com.rajvardhan.app.entities.Employee;

import java.util.ArrayList;
import java.util.List;


public class EmployeeFragment extends Fragment {

    RecyclerView recyclerView;
    List<Employee> employeeList;

    EmployeeAdapter employeeAdapter;

    public EmployeeFragment() {
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
        employeeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeList=new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        employeeList.add(new Employee(101, "Rajvardhan Patil", 75000.0));
        employeeList.add(new Employee(102, "Ananya Sharma", 68000.0));
        employeeList.add(new Employee(103, "Amitabh Mishra", 82000.0));
        employeeList.add(new Employee(104, "Priya Kaur", 72000.0));
        employeeList.add(new Employee(105, "Rakesh Nair", 70000.0));

        recyclerView=view.findViewById(R.id.recyclerView);

        employeeAdapter=new EmployeeAdapter(getContext(),employeeList);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

    }
}