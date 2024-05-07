package com.example.handyman;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HandyManAdapter extends RecyclerView.Adapter<HandyManAdapter.ViewHolder> {

    private Context context;
    private List<HandyMan> handyManList;
    public HandyManAdapter(Context context, List<HandyMan> handyManList) {
        this.context = context;
        this.handyManList = handyManList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showing_all_users, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HandyMan handyMan = handyManList.get(position);
        holder.textViewName.setText(handyMan.getName());
        holder.textViewRate.setText(String.valueOf(handyMan.getRate()));
        holder.ratingBar.setRating(handyMan.getRating());

        // Set click listener for the button
        holder.buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the map activity and pass the latitude and longitude

            }
        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity and pass the HandyMan information
                Intent intent = new Intent(context, handymanDetails.class);
                HandyMan handyMan = handyManList.get(holder.getAdapterPosition());
                intent.putExtra("handyman", handyMan);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
         try{
             return   handyManList.size();

         }
        catch (Exception ex){
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewRate;
        public RatingBar ratingBar;
        public Button buttonMap;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewRate = itemView.findViewById(R.id.textViewRate);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            buttonMap = itemView.findViewById(R.id.buttonLocation);
            linearLayout=itemView.findViewById(R.id.linearLayoutShowingAllUers);
        }
    }
}
