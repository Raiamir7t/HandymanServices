package com.example.handyman;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<Service> ServiceList;

    public UserAdapter(Context context, List<Service> ServiceList) {
        this.context = context;
        this.ServiceList = ServiceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service service = ServiceList.get(position);
        holder.textViewUsername.setText(service.getName());
        holder.imageViewUser.setImageResource(service.getImageResId());

        // Set click listeners for both image and text views
        holder.imageViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentShowAllUsers fragment = new FragmentShowAllUsers();
                Bundle bundle = new Bundle();
                bundle.putString("username", service.getName());
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainFragement, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        holder.textViewUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentShowAllUsers fragment = new FragmentShowAllUsers();
                Bundle bundle = new Bundle();
                bundle.putString("username", service.getName());
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainFragement, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ServiceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewUser;
        public TextView textViewUsername;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.imageViewUser);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
        }
    }
}
