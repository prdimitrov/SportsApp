package com.example.sportsapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsapp.R;
import com.example.sportsapp.model.Sport;

import java.util.List;

//This is the bridge between the Data (List<Sport>) and the RecyclerView + CardView
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {

    private List<Sport> sportList;

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflating the layout for each item in the recycler view

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,
                        parent,
                        false);
        return new SportsViewHolder(itemView);
    }

    @Override //!!!!!!!!!!!!Always replace the RecyclerView.ViewHolder holder with
              //the class that is extending it, so here it will be SportsViewHolder
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        /*
        it is called for each item in the list and is responsible for
        binding the data from the Sport object to the views
        withing the 'SportsViewHolder'
        */
        Sport sport = sportList.get(position);
        holder.textView.setText(sport.getSportName());
        holder.imageView.setImageResource(sport.getSportImg());
    }

    @Override
    public int getItemCount() {
        // returns the count of the data list
        return sportList.size();
    }

    public static class SportsViewHolder extends RecyclerView.ViewHolder {
        //This static class holds the references to the views within the item layout

        TextView textView;
        ImageView imageView;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageViewCard);
        }
    }
}
