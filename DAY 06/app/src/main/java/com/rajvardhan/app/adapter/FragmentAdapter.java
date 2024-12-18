package com.rajvardhan.app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.rajvardhan.app.fragments.CountryFragment;
import com.rajvardhan.app.fragments.EmployeeFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new EmployeeFragment();
            case 1:
                return new CountryFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
