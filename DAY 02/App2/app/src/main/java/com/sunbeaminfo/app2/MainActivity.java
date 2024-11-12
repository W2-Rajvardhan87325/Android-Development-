package com.sunbeaminfo.app2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editName,editEmail;
    CheckBox checkboxC,checkboxCPP,checkboxJava;
    RadioButton radioMale,radioFemale;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName =  findViewById(R.id.editName);
        editEmail =  findViewById(R.id.editEmail);
        checkboxC =  findViewById(R.id.checkboxC);
        checkboxCPP =  findViewById(R.id.checkboxCPP);
        checkboxJava =  findViewById(R.id.checkboxJava);
        radioMale =  findViewById(R.id.radioMale);
        radioFemale =  findViewById(R.id.radioFemale);
    }

    public void save(View view){
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        List<String> favLanguages = new ArrayList<>();
        if(checkboxC.isChecked())
            favLanguages.add("C");
        if(checkboxCPP.isChecked())
            favLanguages.add("CPP");
        if(checkboxJava.isChecked())
            favLanguages.add("Java");
        String gender;
        if(radioMale.isChecked())
            gender = "Male";
        else
            gender = "Female";

        Log.e(TAG,name);
        Log.e(TAG,email);
        Log.e(TAG,favLanguages.toString());
        Log.e(TAG,gender);

    }


    public void clear(View view){
        editName.setText("");
        editEmail.setText("");
        checkboxC.setChecked(false);
        checkboxCPP.setChecked(false);
        checkboxJava.setChecked(false);
        radioMale.setChecked(false);
        radioFemale.setChecked(false);
    }
}