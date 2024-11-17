package com.sunbeaminfo.mobilestore.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.entity.User;
import com.sunbeaminfo.mobilestore.utils.Constants;
import com.sunbeaminfo.mobilestore.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail, editPassword;
    TextView textRegister;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        textRegister = findViewById(R.id.textRegister);
        checkBox = findViewById(R.id.checkBox);

        // to navigate to the HomeActivity if the user has checked remember me
        if(getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME,MODE_PRIVATE).getBoolean(Constants.LOGIN_STATUS,false)) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
            textRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    public void login(View view) {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        if (email.equals(""))
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        else if (password.equals(""))
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        else {
            RetrofitClient.getInstance().getApi().loginUser(new User(email, password)).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.body().get("status").getAsString().equals("success")) {
                        int id = response.body().get("data").getAsJsonObject().get("id").getAsInt();
                        SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCE_FILE_NAME, MODE_PRIVATE);
                        preferences.edit().putInt(Constants.USER_ID, id).apply();
                        if (checkBox.isChecked())
                            preferences.edit().putBoolean(Constants.LOGIN_STATUS, true).apply();
                        Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    } else
                        Toast.makeText(LoginActivity.this, "Invalid Credentials...", Toast.LENGTH_SHORT).show();

                }


                @Override
                public void onFailure(Call<JsonObject> call, Throwable throwable) {
                    Toast.makeText(LoginActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}