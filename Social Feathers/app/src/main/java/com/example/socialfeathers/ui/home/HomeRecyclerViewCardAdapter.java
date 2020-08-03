package com.example.socialfeathers.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.socialfeathers.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeRecyclerViewCardAdapter extends RecyclerView.Adapter<HomeRecyclerViewCardAdapter.HomeRecyclerViewCardHolder> {

    //TODO: more info
    private List<String> homeCardList = new ArrayList<>();

    class HomeRecyclerViewCardHolder extends RecyclerView.ViewHolder{

        //TODO: more info
        private TextView homeCardTitle;

        public HomeRecyclerViewCardHolder(@NonNull View itemView) {
            super(itemView);

            homeCardTitle = itemView.findViewById(R.id.homeCardTitle);
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

        //TODO: more info
        String currentHomeCard = homeCardList.get(position);
        holder.homeCardTitle.setText(currentHomeCard);
    }

    @Override
    public int getItemCount() {
        return homeCardList.size();
    }


    // TODO: more info
    public void setHomeCardList(List<String> homeCardList){
        this.homeCardList = homeCardList;
        notifyDataSetChanged();
    }
}
