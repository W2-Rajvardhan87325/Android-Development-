package com.sunbeaminfo.mobilestore.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.JsonObject;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.entity.User;
import com.sunbeaminfo.mobilestore.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText editEmail, editName, editPassword, editConfirmPassword, editMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);
        editMobile = findViewById(R.id.editMobile);
    }

    public User validateUser() {
        String name, email, password, confirmPassword, mobile;
        name = editName.getText().toString();
        email = editEmail.getText().toString();
        password = editPassword.getText().toString();
        confirmPassword = editConfirmPassword.getText().toString();
        mobile = editMobile.getText().toString();
        if (name.equals(""))
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        else if (email.equals(""))
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        else if (password.equals(""))
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        else if (confirmPassword.equals(""))
            Toast.makeText(this, "Confirm Password cannot be empty", Toast.LENGTH_SHORT).show();
        else if (mobile.equals(""))
            Toast.makeText(this, "Mobile cannot be empty", Toast.LENGTH_SHORT).show();
        else {
            if (password.equals(confirmPassword))
                return new User(0, name, email, password, mobile);
            else
                Toast.makeText(this, "passwords does not match", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public void register(View view) {
        User user = validateUser();
        if (user != null)
            RetrofitClient.getInstance().getApi().registerUser(user).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (response.body().get("status").getAsString().equals("success")) {
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(RegisterActivity.this, "User Registration failed", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable throwable) {
                    Toast.makeText(RegisterActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
                }
            });

    }

    public void cancel(View view) {
        finish();
    }
}