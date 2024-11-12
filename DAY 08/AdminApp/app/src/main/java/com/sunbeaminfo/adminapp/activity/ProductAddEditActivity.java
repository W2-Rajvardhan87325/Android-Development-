package com.sunbeaminfo.adminapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sunbeaminfo.adminapp.R;
import com.sunbeaminfo.adminapp.db.ProductDbHelper;
import com.sunbeaminfo.adminapp.entity.Product;

public class ProductAddEditActivity extends AppCompatActivity {
    TextView textName;
    EditText editName, editPrice;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add_edit);
        textName = findViewById(R.id.textName);
        editName = findViewById(R.id.editName);
        editPrice = findViewById(R.id.editPrice);
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        if (product != null) {
            textName.setText("Edit Product");
            editName.setText(product.getName());
            editPrice.setText("" + product.getPrice());
        } else
            textName.setText("Add Product");
    }

    public void save(View view) {
        ProductDbHelper dbHelper = new ProductDbHelper(this);

        if (product == null) {
            product = new Product();
            product.setName(editName.getText().toString());
            product.setPrice(Double.parseDouble(editPrice.getText().toString()));
            dbHelper.insertProduct(product);
        }
        else {
            product.setName(editName.getText().toString());
            product.setPrice(Double.parseDouble(editPrice.getText().toString()));
            dbHelper.editProduct(product);
        }
        finish();
    }
}