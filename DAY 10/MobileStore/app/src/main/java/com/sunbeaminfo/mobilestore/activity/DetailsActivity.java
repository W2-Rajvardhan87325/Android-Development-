package com.sunbeaminfo.mobilestore.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.entity.Mobile;
import com.sunbeaminfo.mobilestore.utils.Constants;

public class DetailsActivity extends AppCompatActivity {
    TextView textName,textCompany,textPrice,textRam,textStorage;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textName = findViewById(R.id.textName);
        textCompany = findViewById(R.id.textCompany);
        textPrice = findViewById(R.id.textPrice);
        textRam = findViewById(R.id.textRam);
        textStorage = findViewById(R.id.textStorage);
        imageView = findViewById(R.id.imageView);

        Mobile mobile = (Mobile) getIntent().getSerializableExtra(Constants.MOBILE);
        textName.setText("Name - "+mobile.getName());
        textCompany.setText("Company - "+mobile.getCompany());
        textPrice.setText("Rs - "+mobile.getPrice());
        textRam.setText("Ram - "+mobile.getRam());
        textStorage.setText("Storage - "+mobile.getStorage());
        Glide.with(this).load(Constants.BASE_URL+"/images/"+mobile.getImage()).into(imageView);
    }
}