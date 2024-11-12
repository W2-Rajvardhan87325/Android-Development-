package com.rajvardhan.app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajvardhan.app.R;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    Context context;
    List<String> countryList;
    public CountryAdapter(Context context, List<String> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.country_vh, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.countryName.setText(countryList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView countryName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName=itemView.findViewById(R.id.countryName);
        }
    }
}
