package com.example.mymeteireannclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
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
    String longitute,latitute;

    Button newPrefBtn,viewPrefBtn;
    private PackageManager PackageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newPrefBtn=findViewById(R.id.Update_Pref_btn);
        viewPrefBtn=findViewById(R.id.Delete_pref_btn);



        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        newPrefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigation to next screen

                startActivity(new Intent(getApplicationContext(),AddNewPreferencesActivity.class));
            }
        });

        viewPrefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewAllPreferences.class));
            }
        });

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

    }

}
