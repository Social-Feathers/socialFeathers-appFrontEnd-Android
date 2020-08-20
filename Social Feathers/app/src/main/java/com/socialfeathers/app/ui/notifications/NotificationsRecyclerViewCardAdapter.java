package com.socialfeathers.app.ui.notifications;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.socialfeathers.app.CauseDetailsActivity;
import com.socialfeathers.app.R;
import com.socialfeathers.app.ui.home.CauseData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationsRecyclerViewCardAdapter extends RecyclerView.Adapter<NotificationsRecyclerViewCardAdapter.NotificationsRecyclerViewCardHolder> {

    //TODO: more info
    private List<NotificationsData> notificationsCardList = new ArrayList<>();

    static class NotificationsRecyclerViewCardHolder extends RecyclerView.ViewHolder{

        private TextView notificationsCardDetails;
        private ImageView notificationsCardUserPic;
        private ImageView notificationsCardImage;


        public NotificationsRecyclerViewCardHolder(@NonNull View itemView) {
            super(itemView);

            notificationsCardDetails = itemView.findViewById(R.id.notificationsCardDetails);
            notificationsCardUserPic = itemView.findViewById(R.id.notificationsCardUserPic);
            notificationsCardImage = itemView.findViewById(R.id.notificationsCardPreviewImage);
        }
    }

    @NonNull
    @Override
    public NotificationsRecyclerViewCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_notifications_card_layout,parent,false);
        return new NotificationsRecyclerViewCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsRecyclerViewCardHolder holder, int position) {

        final NotificationsData currentNotificationsCardData = notificationsCardList.get(position);

        holder.notificationsCardDetails.setText(currentNotificationsCardData.getDetails());

        holder.notificationsCardUserPic.setImageResource(holder.notificationsCardImage.getContext().getResources().getIdentifier(currentNotificationsCardData.getUserPic(),"drawable",holder.notificationsCardImage.getContext().getPackageName()));

        holder.notificationsCardImage.setImageResource(holder.notificationsCardImage.getContext().getResources().getIdentifier(currentNotificationsCardData.getPreviewImage(),"drawable",holder.notificationsCardImage.getContext().getPackageName()));

    }

    @Override
    public int getItemCount() {
        return notificationsCardList.size();
    }


    // TODO: more info
    public void setHomeCardList(List<NotificationsData> notificationsCardList){
        this.notificationsCardList = notificationsCardList;
        notifyDataSetChanged();
    }
}
