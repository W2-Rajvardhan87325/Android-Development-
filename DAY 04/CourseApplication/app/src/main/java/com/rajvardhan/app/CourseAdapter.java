package com.rajvardhan.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {

    Context context;

    List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Course course = courseList.get(position);
        holder.courseImage.setImageResource(course.getCourseImage());
        holder.courseName.setText(course.getCourseName());
        holder.courseFees.setText("" + course.getCourseFees());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView courseName, courseFees;
        ImageView courseImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseName);
            courseFees = itemView.findViewById(R.id.courseFees);
            courseImage = itemView.findViewById(R.id.courseImage);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, CourseDetailsActivity.class);
                    intent.putExtra("courseDetails",courseList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
