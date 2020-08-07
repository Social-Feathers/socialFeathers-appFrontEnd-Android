package com.socialfeathers.app;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CauseDetailsActivity extends AppCompatActivity {

    private CauseData causeData;

    private TextView usernameView,dateView,addressView,detailsView;
    private ImageView userImageView,previewImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cause_details);

        Bundle extras = getIntent().getExtras();
        causeData = new CauseData(extras.getString("username"),extras.getString("tag"),extras.getString("title"),extras.getString("address"),extras.getString("details"),extras.getString("date"),extras.getString("userPic"),extras.getString("previewImage"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(causeData.getTitle());

        userImageView = findViewById(R.id.causeDetailsUserPic);
        assert userImageView != null;
        userImageView.setImageResource(getResources().getIdentifier(causeData.getUserPic(),"drawable",getPackageName()));

        previewImageview = findViewById(R.id.causeDetailsPreviewImage);
        assert previewImageview != null;
        previewImageview.setImageResource(getResources().getIdentifier(causeData.getPreviewImage(),"drawable",getPackageName()));

        usernameView = findViewById(R.id.causeDetailsUsername);
        assert usernameView != null;
        usernameView.setText(causeData.getUsername());

        dateView = findViewById(R.id.causeDetailsDate);
        assert dateView != null;
        dateView.setText(causeData.getDate());

        addressView = findViewById(R.id.causeDetailsAddress);
        assert addressView != null;
        addressView.setText(causeData.getAddress());

        detailsView = findViewById(R.id.causeDetailsDetails);
        assert detailsView != null;
        detailsView.setText(causeData.getDetails());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater causeDetailsMenuInflater = getMenuInflater();
        causeDetailsMenuInflater.inflate(R.menu.menu_cause_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_bookmark:
                // Todo: bookmark action
                break;
            case R.id.action_share:
                // Todo: share action
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}