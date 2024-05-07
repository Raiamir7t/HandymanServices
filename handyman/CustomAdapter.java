package com.example.handyman;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<DataModel> dataList;

    public CustomAdapter(List<DataModel> dataList) {
        this.dataList = dataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView serviceTextView;
        TextView dateTextView;
        TextView timeTextView;
        Button continueButton;
        Button cancelButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceTextView = itemView.findViewById(R.id.serviceTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            continueButton = itemView.findViewById(R.id.continueButton);
            cancelButton = itemView.findViewById(R.id.cancelButton);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataModel currentItem = dataList.get(position);
            int w=0;
        holder.serviceTextView.setText("Service: " + currentItem.getServiceName());
        holder.dateTextView.setText("Date: " + currentItem.getDate());
        holder.timeTextView.setText("Time: " + currentItem.getTime());

        // Set OnClickListener for buttons if needed
        holder.continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle continue button click
            }
        });

        holder.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel button click
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}



