package com.socialfeathers.app.ui.add_event;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.socialfeathers.app.AddCauseActivity;
import com.socialfeathers.app.R;
import com.socialfeathers.app.ui.home.HomeFragment;

public class AddEventFragment extends Fragment {

    private AddEventViewModel addEventViewModel;

    private MaterialButton noAlertButton,yesAlertButton;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        new AlertDialog.Builder(getContext())
//                .setTitle("create a cause?")
//                .setMessage("Are you sure you want to create a new cause?")
//                .setPositiveButton(R.string.AlertDialog_Yes, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        Intent newIntent = new Intent(getActivity(), AddCauseActivity.class);
//                        startActivity(newIntent);
//                    }
//                })
//                .setNegativeButton(R.string.AlertDialog_No, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        FragmentManager manager = getActivity().getSupportFragmentManager();
//                        manager.beginTransaction().replace(R.id.navigation_add_event, new HomeFragment()).commit();
//                    }
//                })
//                .setIcon(R.drawable.ic_baseline_warning_24)
//                .show();

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addEventViewModel =
                ViewModelProviders.of(this).get(AddEventViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_event, container, false);

        yesAlertButton = root.findViewById(R.id.addCauseFragmentYesButton);
        assert yesAlertButton != null;
        yesAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getActivity(), AddCauseActivity.class);
                startActivity(newIntent);
                Navigation.findNavController(v).navigate(R.id.navigation_home);
            }
        });

        noAlertButton = root.findViewById(R.id.addCauseFragmentNoButton);
        assert noAlertButton != null;
        noAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_home);
            }
        });

//        final TextView textView = root.findViewById(R.id.text_add_event);
//        addEventViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;

    }
}