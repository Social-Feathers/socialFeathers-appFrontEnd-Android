package com.socialfeathers.app.ui.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.socialfeathers.app.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventsRecyclerViewCardAdapter extends RecyclerView.Adapter<EventsRecyclerViewCardAdapter.EventsRecyclerViewCardHolder> {

    //TODO: more info
    private List<EventsData> eventsCardList = new ArrayList<>();

    static class EventsRecyclerViewCardHolder extends RecyclerView.ViewHolder{

        private ImageButton shareButton;
        private ImageButton bookmarkButton;
        private MaterialButton joinButton;
        private TextView eventsCardTitle;
        private TextView eventsCardDetails;
        private ImageView eventsCardImage;

        public EventsRecyclerViewCardHolder(@NonNull View itemView) {
            super(itemView);

            shareButton = itemView.findViewById(R.id.eventsCardShareButton);
            bookmarkButton = itemView.findViewById(R.id.eventsCardBookmarkButton);
            joinButton = itemView.findViewById(R.id.eventsCardJoinButton);
            eventsCardTitle = itemView.findViewById(R.id.eventsCardTitle);
            eventsCardDetails = itemView.findViewById(R.id.eventsCardDetails);
            eventsCardImage = itemView.findViewById(R.id.eventsCardPreviewImage);
        }
    }

    @NonNull
    @Override
    public EventsRecyclerViewCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_events_card_layout,parent,false);
        return new EventsRecyclerViewCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsRecyclerViewCardHolder holder, int position) {

        final EventsData currentEventsCardData = eventsCardList.get(position);

        holder.joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: for events
//                Intent fullscreenCauseIntent = new Intent(v.getContext(), CauseDetailsActivity.class);
//                fullscreenCauseIntent.putExtra("username",currentHomeCardData.getUsername());
//                fullscreenCauseIntent.putExtra("tag",currentHomeCardData.getTag());
//                fullscreenCauseIntent.putExtra("title",currentHomeCardData.getTitle());
//                fullscreenCauseIntent.putExtra("date",currentHomeCardData.getDate());
//                fullscreenCauseIntent.putExtra("address",currentHomeCardData.getAddress());
//                fullscreenCauseIntent.putExtra("details",currentHomeCardData.getDetails());
//                fullscreenCauseIntent.putExtra("previewImage",currentHomeCardData.getPreviewImage());
//                fullscreenCauseIntent.putExtra("userPic",currentHomeCardData.getUserPic());
//                v.getContext().startActivity(fullscreenCauseIntent);
            }
        });

        holder.eventsCardTitle.setText(currentEventsCardData.getTitle());

        holder.eventsCardDetails.setText(currentEventsCardData.getDetails());

        holder.eventsCardImage.setImageResource(holder.eventsCardImage.getContext().getResources().getIdentifier(currentEventsCardData.getPreviewImage(),"drawable",holder.eventsCardImage.getContext().getPackageName()));

    }

    @Override
    public int getItemCount() {
        return eventsCardList.size();
    }


    // TODO: more info
    public void setHomeCardList(List<EventsData> eventsCardList){
        this.eventsCardList = eventsCardList;
        notifyDataSetChanged();
    }
}
