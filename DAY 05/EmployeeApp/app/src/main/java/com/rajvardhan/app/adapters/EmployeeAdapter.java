package com.rajvardhan.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.app.R;
import com.rajvardhan.app.activities.EditEmployeeActivity;
import com.rajvardhan.app.activities.ShowEmpDetailsActivity;
import com.rajvardhan.app.entities.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {

    Context context;
    List<Employee> employeeList;

    ActivityResultLauncher launcher;

    public EmployeeAdapter(Context context, List<Employee> employeeList, ActivityResultLauncher launcher) {
        this.context = context;
        this.employeeList = employeeList;
        this.launcher = launcher;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.empId.setText("Employee Id  : : " + employeeList.get(position).getEmpId());
        holder.empName.setText("Employee Name  : : " + employeeList.get(position).getEmpName());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView empId, empName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            empId = itemView.findViewById(R.id.empId);
            empName = itemView.findViewById(R.id.empName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Displaying Details", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, ShowEmpDetailsActivity.class);
                    intent.putExtra("emp", employeeList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(context, view);
                    popupMenu.getMenu().add("edit");
                    popupMenu.getMenu().add("delete");
                    popupMenu.show();

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getTitle().equals("edit")) {
                                Intent intent = new Intent(context, EditEmployeeActivity.class);
                                intent.putExtra("emp", employeeList.get(getAdapterPosition()));
                                launcher.launch(intent);
                            }
                            if (item.getTitle().equals("delete")) {
                                employeeList.remove(getAdapterPosition());
                                notifyDataSetChanged();
                            }
                            return false;
                        }
                    });

                    return false;
                }
            });
        }
    }
}
