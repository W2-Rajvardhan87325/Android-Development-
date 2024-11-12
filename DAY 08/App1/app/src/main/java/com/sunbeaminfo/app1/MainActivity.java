package com.sunbeaminfo.app1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ContactsListner {
    RecyclerView recyclerView;
    List<Contact> contactList;

    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        contactList = new ArrayList<>();
        adapter = new ContactAdapter(this,contactList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        getContacts();
    }

    public void getContacts(){
        ContentResolver resolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String col_name = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
        String col_phone = ContactsContract.CommonDataKinds.Phone.NUMBER;
        Cursor cursor = resolver.query(uri,new String[]{col_name,col_phone},null,null,null);
        while (cursor.moveToNext())
        {
            Contact contact = new Contact();
            contact.setName(cursor.getString(0));
            contact.setPhone(cursor.getString(1));
            contactList.add(contact);
            //Log.e("MainActivity",cursor.getString(0)+" - "+cursor.getString(1));
        }
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showContatDetails(Contact contact) {
        Toast.makeText(this, "Phone = "+contact.getPhone(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteContact(Contact contact) {
        contactList.remove(contact);
        adapter.notifyDataSetChanged();
    }
}