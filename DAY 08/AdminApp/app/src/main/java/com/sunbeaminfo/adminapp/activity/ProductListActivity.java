package com.sunbeaminfo.adminapp.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunbeaminfo.adminapp.R;
import com.sunbeaminfo.adminapp.adapter.ProductAdapter;
import com.sunbeaminfo.adminapp.db.ProductDbHelper;
import com.sunbeaminfo.adminapp.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ProductAdapter.DeleteListner {
    RecyclerView recyclerView;
    Toolbar toolbar;

    List<Product> productList;

    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        productList = new ArrayList<>();
        adapter = new ProductAdapter(this,productList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllProducts();
    }

    public void getAllProducts(){
        productList.clear();
        //ProductDbHelper dbHelper = new ProductDbHelper(this);
        //Cursor cursor = dbHelper.getAllProducts();

        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://com.sunbeaminfo.adminapp.provider/getAllProducts");
        Cursor cursor = resolver.query(uri,null,null,null,null);

        while (cursor.moveToNext()){
            Product product = new Product();
            product.setPid(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setPrice(cursor.getDouble(2));
            productList.add(product);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add").setIcon(R.drawable.add).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, ProductAddEditActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void deleteProduct(Product product) {
        ProductDbHelper dbHelper = new ProductDbHelper(this);
        dbHelper.deleteProduct(product);
        getAllProducts();

    }
}