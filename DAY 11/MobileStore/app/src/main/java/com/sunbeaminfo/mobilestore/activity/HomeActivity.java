package com.sunbeaminfo.mobilestore.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.sunbeaminfo.mobilestore.R;
import com.sunbeaminfo.mobilestore.adapter.MobileFragmentAdapter;

public class HomeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    MobileFragmentAdapter mobileFragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        mobileFragmentAdapter = new MobileFragmentAdapter(this);
        viewPager2.setAdapter(mobileFragmentAdapter);
        new TabLayoutMediator(tabLayout, viewPager2,(tab, position) -> {
            switch (position){
                case 0:
                    tab.setIcon(R.drawable.mobile_list);
                    break;
                case 1:
                    tab.setIcon(R.drawable.orders);
                    break;
                case 2:
                    tab.setIcon(R.drawable.profile);
                    break;
            }
        }).attach();
    }
}