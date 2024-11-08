package com.rajvardhan.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.app.R;
import com.rajvardhan.app.activities.StudentDetailsActivity;
import com.rajvardhan.app.activities.StudentEditActivity;
import com.rajvardhan.app.entities.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    Context context;
    List<Student> studentList;

    ActivityResultLauncher launcher;

    public StudentAdapter(Context context, List<Student> studentList, ActivityResultLauncher launcher) {
        this.context = context;
        this.studentList = studentList;
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
        holder.rollNo.setText("Roll Number : : " + studentList.get(position).getRollNo());
        holder.name.setText("Name             : : " + studentList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rollNo, name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rollNo = itemView.findViewById(R.id.rollNo);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Displaying Details", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, StudentDetailsActivity.class);
                    intent.putExtra("student", studentList.get(getAdapterPosition()));
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
                                Intent intent=new Intent(context, StudentEditActivity.class);
                                intent.putExtra("student",studentList.get(getAdapterPosition()));
                                launcher.launch(intent);
                            }
                            if (item.getTitle().equals("delete")){
                                studentList.remove(getAdapterPosition());
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
