package com.rajvardhan.viewpagertablayoutapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.rajvardhan.viewpagertablayoutapp.Fragments.FirstFragment;
import com.rajvardhan.viewpagertablayoutapp.Fragments.SecondFragment;
import com.rajvardhan.viewpagertablayoutapp.Fragments.ThirdFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
