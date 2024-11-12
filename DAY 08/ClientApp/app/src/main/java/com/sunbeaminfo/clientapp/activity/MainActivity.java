package com.sunbeaminfo.clientapp.activity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeaminfo.clientapp.R;
import com.sunbeaminfo.clientapp.adapter.ProductAdapter;
import com.sunbeaminfo.clientapp.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Product> productList;

    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();
        productList.add(new Product(1, "test", 0));
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllProducts();
    }

    public void getAllProducts() {
        productList.clear();
        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://com.sunbeaminfo.adminapp.provider/getAllProducts");
        Cursor cursor = resolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()){
            Product product = new Product();
            product.setPid(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setPrice(cursor.getDouble(2));
            productList.add(product);
        }
        adapter.notifyDataSetChanged();
    }
}