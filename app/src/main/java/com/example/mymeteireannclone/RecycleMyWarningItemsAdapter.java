package com.example.mymeteireannclone;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//Usama Ali Khan
//17810


public class RecycleMyWarningItemsAdapter extends RecyclerView.Adapter<RecycleMyWarningItemsAdapter.ItemsViewHolder> {

    private Context mContext;
    private List<WarningItem> mData;

    public RecycleMyWarningItemsAdapter() {

    }

    public RecycleMyWarningItemsAdapter(Context mContext, List<?> Data) {
        this.mContext = mContext;
        this.mData = (List<WarningItem>) Data;

    }

    @NonNull
    @Override
    //overriding the onCreateViewHolder to inflate the weather_recycler layout in the recyclerView
    public RecycleMyWarningItemsAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(mContext).inflate(R.layout.mywarning_recycler_layout, parent,false);

        return new RecycleMyWarningItemsAdapter.ItemsViewHolder(mView);

    }


    @Override
    //binding the data from list to the recycler view items
    public void onBindViewHolder(@NonNull RecycleMyWarningItemsAdapter.ItemsViewHolder holder, final int position) {

        //getting item selected from recyclerView
        final WarningItem gItem=mData.get(position);

        holder.area.setText(gItem.getArea());
        holder.type.setText(gItem.getType());
        if (gItem.getLevel().equals("Red Level")){
            holder.level.setImageResource(R.drawable.warning_icon);
        }else{
            holder.level.setImageResource(R.drawable.yellow_warning_icon);
        }

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        //navigation to edit warnings activity for a weather item on selected position
                    Intent myIntent=new Intent(mContext,AddNewPreferencesActivity.class);
                    myIntent.putExtra("position",position);
                    mContext.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

        //binding the itemViews in recyclerView to their instances
    public static class ItemsViewHolder extends RecyclerView.ViewHolder{

        TextView area,type;
        ImageView level;
        ImageButton editBtn;


        public ItemsViewHolder(View itemView) {
            super(itemView);

            area=itemView.findViewById(R.id.mywarning_area);
            type=itemView.findViewById(R.id.mywarning_type);
            level=itemView.findViewById(R.id.mywarning_level);
            editBtn=itemView.findViewById(R.id.edit_mywarning_btn);

        }
    }




}
