package com.example.mymeteireannclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

//Usama Ali Khan
//17810


//adapter class for recycling views in recyclerViewWidget

public class RecycleWeatherItemsAdapter extends RecyclerView.Adapter<RecycleWeatherItemsAdapter.ItemsViewHolder>{


    private Context mContext;
    private List<WeatherItem> mData;

    public RecycleWeatherItemsAdapter(Context mContext, List<?> Data) {
        this.mContext = mContext;
        this.mData = (List<WeatherItem>) Data;

    }

    @NonNull
    @Override
    //overriding the onCreateViewHolder to inflate the weather_recycler layout in the recyclerView
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(mContext).inflate(R.layout.weather_recycler_layout, parent,false);

        return new ItemsViewHolder(mView);

    }


    @Override
    //binding the data from list to the recycler view items
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {

        //getting item selected from recyclerView
        final WeatherItem gItem=mData.get(position);


        holder.day.setText(gItem.getDay());
        holder.centigrade.setText(Integer.toString(gItem.getCentigrade()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    //binding the itemViews in recyclerView to their instances
    public static class ItemsViewHolder extends RecyclerView.ViewHolder{

        TextView day,centigrade;


        public ItemsViewHolder(View itemView) {
            super(itemView);

            day=itemView.findViewById(R.id.day);
            centigrade=itemView.findViewById(R.id.centigrade);

        }
    }



}
