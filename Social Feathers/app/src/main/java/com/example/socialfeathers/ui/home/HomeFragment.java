package com.example.socialfeathers.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialfeathers.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        View homeFragmentRootView = inflater.inflate(R.layout.fragment_home, container, false);


        RecyclerView homeRecyclerView = homeFragmentRootView.findViewById(R.id.homeFragmentRecyclerView);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //TODO: May need to change
        homeRecyclerView.setHasFixedSize(true);

        final HomeRecyclerViewCardAdapter homeRecyclerViewCardAdapter = new HomeRecyclerViewCardAdapter();
        homeRecyclerView.setAdapter(homeRecyclerViewCardAdapter);


        homeViewModel.getTitles().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> s) {

                // Todo:
                homeRecyclerViewCardAdapter.setHomeCardList(s);
            }
        });


        return homeFragmentRootView;
    }
}