package com.sunbeaminfo.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    Context context;
    List<Contact> conatctList;
    interface ContactsListner{
        void showContatDetails(Contact contact);
        void deleteContact(Contact contact);
    }

    ContactsListner listner;

    public ContactAdapter(Context context, List<Contact> conatctList, ContactsListner listner) {
        this.context = context;
        this.conatctList = conatctList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(conatctList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return conatctList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(v -> listner.showContatDetails(conatctList.get(getAdapterPosition())));
            itemView.setOnLongClickListener(v -> {
                listner.deleteContact(conatctList.get(getAdapterPosition()));
                return false;
            });
        }
    }
}
