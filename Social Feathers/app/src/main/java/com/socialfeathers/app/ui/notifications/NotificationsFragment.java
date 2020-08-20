package com.socialfeathers.app.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.socialfeathers.app.R;
import com.socialfeathers.app.ui.home.CauseData;
import com.socialfeathers.app.ui.home.HomeRecyclerViewCardAdapter;

import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        View notificationsFragmentRootView = inflater.inflate(R.layout.fragment_notifications, container, false);

        RecyclerView notificationsRecyclerView = notificationsFragmentRootView.findViewById(R.id.notificationsFragmentRecyclerView);
        notificationsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //TODO: May need to change
        notificationsRecyclerView.setHasFixedSize(true);

        final NotificationsRecyclerViewCardAdapter notificationsRecyclerViewCardAdapter = new NotificationsRecyclerViewCardAdapter();
        notificationsRecyclerView.setAdapter(notificationsRecyclerViewCardAdapter);


        notificationsViewModel.getTitles().observe(getViewLifecycleOwner(), new Observer<List<NotificationsData>>() {
            @Override
            public void onChanged(@Nullable List<NotificationsData> causeData) {

                // Todo:
                notificationsRecyclerViewCardAdapter.setHomeCardList(causeData);
            }
        });


        return notificationsFragmentRootView;
    }
}