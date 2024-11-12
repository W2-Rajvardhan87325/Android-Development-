package com.rajvardhan.app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rajvardhan.app.R;
import com.rajvardhan.app.adapter.CountryAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CountryFragment extends Fragment {

    RecyclerView recyclerView;
    List<String> countrylist;
    CountryAdapter adapter;

    public CountryFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countrylist=new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Collections.addAll(countrylist, "India", "Japan", "Germany", "Brazil", "Canada", "Australia", "France", "Italy", "Mexico", "South Korea", "United Kingdom");

        recyclerView=view.findViewById(R.id.recyclerView);
        adapter=new CountryAdapter(getContext(),countrylist);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
    }
}