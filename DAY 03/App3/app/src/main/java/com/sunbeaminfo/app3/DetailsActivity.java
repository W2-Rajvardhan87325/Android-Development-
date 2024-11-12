package com.sunbeaminfo.app3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
    TextView textEmpid,textName,textEmail,textSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textEmpid = findViewById(R.id.textEmpid);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textSalary = findViewById(R.id.textSalary);
    }

    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Intent intent = result.getData();
            Employee e = (Employee) intent.getSerializableExtra("employee");
            textEmpid.setText("id - "+e.getEmpid());
            textName.setText("Name - "+e.getName());
            textEmail.setText(e.getEmail());
            textSalary.setText("Salary - "+e.getSalary());
        }
    });



    public void getData(View v){
        Intent intent = new Intent(this, MainActivity.class);
        launcher.launch(intent);
    }
}