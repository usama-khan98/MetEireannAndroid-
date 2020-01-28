package com.example.mymeteireannclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


//Usama Ali Khan
//17810

public class MainActivity extends AppCompatActivity {


    RecyclerView weatherRecycler;
    RecycleWeatherItemsAdapter recycleWeatherItemsAdapter;
    List<WeatherItem> weatherItemList=new ArrayList<>();

    Button myWarningsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherRecycler=findViewById(R.id.recycleview_weather);

        //recycler adapter creation with weatherItemList
        recycleWeatherItemsAdapter=new RecycleWeatherItemsAdapter(this,weatherItemList);

        //weather recycler view layout and decorations
        weatherRecycler.setLayoutManager(new LinearLayoutManager(this));
        weatherRecycler.setItemAnimator(new DefaultItemAnimator());
        weatherRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //associating recycler view with recycler adapter
        weatherRecycler.setAdapter(recycleWeatherItemsAdapter);

        //creation of list for weather items
        weatherItemList.add(new WeatherItem("Monday",3));
        weatherItemList.add(new WeatherItem("Tuesday",6));
        weatherItemList.add(new WeatherItem("Wednesday",9));
        weatherItemList.add(new WeatherItem("Thursday",5));
        weatherItemList.add(new WeatherItem("Friday",4));
        weatherItemList.add(new WeatherItem("Saturday",6));
        weatherItemList.add(new WeatherItem("Sunday",7));

        //to update data displayed in recycler view
        recycleWeatherItemsAdapter.notifyDataSetChanged();


        myWarningsBtn=findViewById(R.id.my_warnings_btn);

        myWarningsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigation to next screen
                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });
    }
}
