package com.rajvardhan.mobileapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.rajvardhan.mobileapplication.R;
import com.rajvardhan.mobileapplication.activities.entities.User;
import com.rajvardhan.mobileapplication.activities.utlis.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAddEditActivity extends AppCompatActivity {
    TextView textName;
    User user;
    EditText editName, editEmail, editPassword, editMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_edit);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editMobile = findViewById(R.id.editMobile);
        textName = findViewById(R.id.textName);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        if (user != null) {
            textName.setText("Edit User");
            editName.setText(user.getName());
            editEmail.setText(user.getEmail());
            editMobile.setText(user.getMobile());
            editPassword.setVisibility(View.INVISIBLE);
        } else
            textName.setText("Add User");
    }


    private void insertUser() {
        user = new User();
        user.setName(editName.getText().toString());
        user.setEmail(editEmail.getText().toString());
        user.setPassword(editPassword.getText().toString());
        user.setMobile(editMobile.getText().toString());
        RetrofitClient.getInstance().getApi().insertUser(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body().get("status").getAsString().equals("success")) {
                    Toast.makeText(UserAddEditActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(UserAddEditActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUser() {
        user.setName(editName.getText().toString());
        user.setEmail(editEmail.getText().toString());
        user.setMobile(editMobile.getText().toString());
        RetrofitClient.getInstance().getApi().updateUser(user,user.getId()).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body().get("status").getAsString().equals("success")) {
                    Toast.makeText(UserAddEditActivity.this, "User Updated Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(UserAddEditActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void save(View view) {
        if (user == null)
            insertUser();
        else
            updateUser();
    }
}