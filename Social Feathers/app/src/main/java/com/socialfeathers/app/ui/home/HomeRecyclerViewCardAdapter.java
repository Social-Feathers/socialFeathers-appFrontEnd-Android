package com.socialfeathers.app.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.socialfeathers.app.CauseDetailsActivity;
import com.socialfeathers.app.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewCardAdapter extends RecyclerView.Adapter<HomeRecyclerViewCardAdapter.HomeRecyclerViewCardHolder> {

    //TODO: more info
    private List<CauseData> homeCardList = new ArrayList<>();

    static class HomeRecyclerViewCardHolder extends RecyclerView.ViewHolder{

        private ImageButton shareButton;
        private ImageButton bookmarkButton;
        private TextView homeCardUsername;
        private TextView homeCardTag;
        private TextView homeCardTitle;
        private TextView homeCardDate;
        private TextView homeCardAddress;
        private TextView homeCardDetails;
        private TextView homeCardReadMoreButton;
        private ImageView homeCardUserPic;
        private ImageView homeCardImage;


        public HomeRecyclerViewCardHolder(@NonNull View itemView) {
            super(itemView);

            shareButton = itemView.findViewById(R.id.homeCardShareButton);
            bookmarkButton = itemView.findViewById(R.id.homeCardBookmarkButton);
            homeCardUsername = itemView.findViewById(R.id.homeCardUsername);
            homeCardTag = itemView.findViewById(R.id.homeCardTag);
            homeCardTitle = itemView.findViewById(R.id.homeCardTitle);
            homeCardDate = itemView.findViewById(R.id.homeCardDate);
            homeCardAddress = itemView.findViewById(R.id.homeCardAddress);
            homeCardDetails = itemView.findViewById(R.id.homeCardDetails);
            homeCardReadMoreButton = itemView.findViewById(R.id.homeCardReadMoreButton);
            homeCardUserPic = itemView.findViewById(R.id.homeCardUserPic);
            homeCardImage = itemView.findViewById(R.id.homeCardPreviewImage);
        }
    }

    @NonNull
    @Override
    public HomeRecyclerViewCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_card_layout,parent,false);
        return new HomeRecyclerViewCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewCardHolder holder, int position) {

        final CauseData currentHomeCardData = homeCardList.get(position);

        holder.homeCardReadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fullscreenCauseIntent = new Intent(v.getContext(), CauseDetailsActivity.class);
                fullscreenCauseIntent.putExtra("username",currentHomeCardData.getUsername());
                fullscreenCauseIntent.putExtra("tag",currentHomeCardData.getTag());
                fullscreenCauseIntent.putExtra("title",currentHomeCardData.getTitle());
                fullscreenCauseIntent.putExtra("date",currentHomeCardData.getDate());
                fullscreenCauseIntent.putExtra("address",currentHomeCardData.getAddress());
                fullscreenCauseIntent.putExtra("details",currentHomeCardData.getDetails());
                fullscreenCauseIntent.putExtra("previewImage",currentHomeCardData.getPreviewImage());
                fullscreenCauseIntent.putExtra("userPic",currentHomeCardData.getUserPic());
                v.getContext().startActivity(fullscreenCauseIntent);
            }
        });

        holder.homeCardTitle.setText(currentHomeCardData.getTitle());
        holder.homeCardUsername.setText(currentHomeCardData.getUsername());
        holder.homeCardTag.setText(currentHomeCardData.getTag());
        // ToDo : change
        holder.homeCardDate.setText(currentHomeCardData.getDate());

        holder.homeCardAddress.setText(currentHomeCardData.getAddress());
        holder.homeCardDetails.setText(currentHomeCardData.getDetails());

        holder.homeCardUserPic.setImageResource(holder.homeCardImage.getContext().getResources().getIdentifier(currentHomeCardData.getUserPic(),"drawable",holder.homeCardImage.getContext().getPackageName()));
        holder.homeCardImage.setImageResource(holder.homeCardImage.getContext().getResources().getIdentifier(currentHomeCardData.getPreviewImage(),"drawable",holder.homeCardImage.getContext().getPackageName()));


    }

    @Override
    public int getItemCount() {
        return homeCardList.size();
    }


    // TODO: more info
    public void setHomeCardList(List<CauseData> homeCardList){
        this.homeCardList = homeCardList;
        notifyDataSetChanged();
    }
}
