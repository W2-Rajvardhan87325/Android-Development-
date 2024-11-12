package com.rajvardhan.app.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.rajvardhan.app.R;
import com.rajvardhan.app.daos.DbHelper;
import com.rajvardhan.app.entities.User;

public class RegisterActivity extends AppCompatActivity {

    EditText addName,addEmail,addPassword,addConfirmPassword;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        dbHelper=new DbHelper(getApplicationContext());
    }

    public void cancel(View view){
        finish();
    }

    public void addUser(View view){
        User user;
        String name=addName.getText().toString();
        String email=addEmail.getText().toString();
        String password=addPassword.getText().toString();
        String confirmPassword=addConfirmPassword.getText().toString();

        if (password.equals(confirmPassword)){
            user=new User(0,name,email,password);
            Log.e("addUser: ", user.toString());
            dbHelper.insertUser(user);
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
        }
    }

    public void init(){
        addName=findViewById(R.id.addName);
        addEmail=findViewById(R.id.addEmail);
        addPassword=findViewById(R.id.addPassword);
        addConfirmPassword=findViewById(R.id.addConfirmPassword);
    }
}