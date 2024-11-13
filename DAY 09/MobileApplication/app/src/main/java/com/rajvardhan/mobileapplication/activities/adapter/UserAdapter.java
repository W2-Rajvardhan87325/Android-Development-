package com.rajvardhan.mobileapplication.activities.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;
import com.rajvardhan.mobileapplication.R;
import com.rajvardhan.mobileapplication.activities.UserAddEditActivity;
import com.rajvardhan.mobileapplication.activities.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context context;
    List<User> userList;

    public interface UserListner{
        void deleteUser(int id);
    }

    UserListner userListner;

    public UserAdapter(Context context, List<User> userList, UserListner userListner) {
        this.context = context;
        this.userList = userList;
        this.userListner = userListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textName.setText(user.getName());
        holder.textPhone.setText(user.getMobile());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textName,textPhone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textPhone = itemView.findViewById(R.id.textPhone);
            itemView.setOnLongClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context,v);
                popupMenu.getMenu().add("edit");
                popupMenu.getMenu().add("delete");
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(item -> {
                    if(item.getTitle().equals("edit")){
                        Intent intent = new Intent(context, UserAddEditActivity.class);
                        intent.putExtra("user",userList.get(getAdapterPosition()));
                        context.startActivity(intent);
                    }
                    if(item.getTitle().equals("delete")){
                        userListner.deleteUser(userList.get(getAdapterPosition()).getId());
                    }
                    return false;
                });
                return false;
            });
        }
    }
}
