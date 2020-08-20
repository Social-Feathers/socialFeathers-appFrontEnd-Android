package com.socialfeathers.app.ui.events;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socialfeathers.app.R;

import java.util.List;

public class EventsFragment extends Fragment {

    private EventsViewModel eventsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel = new ViewModelProvider(this).get(EventsViewModel.class);

        View eventsFragmentRootView = inflater.inflate(R.layout.fragment_events, container, false);


        RecyclerView eventsRecyclerView = eventsFragmentRootView.findViewById(R.id.eventsFragmentRecyclerView);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //TODO: May need to change
        eventsRecyclerView.setHasFixedSize(true);

        final EventsRecyclerViewCardAdapter eventsRecyclerViewCardAdapter = new EventsRecyclerViewCardAdapter();
        eventsRecyclerView.setAdapter(eventsRecyclerViewCardAdapter);


        eventsViewModel.getTitles().observe(getViewLifecycleOwner(), new Observer<List<EventsData>>() {
            @Override
            public void onChanged(@Nullable List<EventsData> eventsData) {

                // Todo:
                eventsRecyclerViewCardAdapter.setHomeCardList(eventsData);
            }
        });


        return eventsFragmentRootView;
    }
}