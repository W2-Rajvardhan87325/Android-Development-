package com.rajvardhan.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rajvardhan.app.R;
import com.rajvardhan.app.daos.DbHelper;
import com.rajvardhan.app.entities.User;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button button;

    User user;
    TextView register;

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerUser);
    }

    public void login(View view) {
        dbHelper = new DbHelper(this);
        user=new User(1, "Rajvardhan Patil", "raj@gmail.com", "pass");
        dbHelper.insertUser(user);
        String tempEmail = email.getText().toString();
        String tempPassword = password.getText().toString();


        User user = dbHelper.Credentials(tempEmail, tempPassword);
        if (user!=null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}