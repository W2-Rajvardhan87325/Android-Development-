package com.rajvardhan.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    Context context;
    List<String> countrylist;

    public CountryAdapter() {
    }

    public CountryAdapter(Context context, List<String> countrylist) {
        this.context = context;
        this.countrylist = countrylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.countryName.setText(countrylist.get(position));
    }

    @Override
    public int getItemCount() {
        return countrylist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
        }
    }
}
