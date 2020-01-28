package com.example.mymeteireannclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


//Usama Ali Khan
//17810

public class MyWarningsActivity extends AppCompatActivity {

    RecyclerView warningsRecycler;
    RecycleMyWarningItemsAdapter recycleMyWarningItemsAdapter;
    public static List<WarningItem> warningsList=new ArrayList<>();


    Button addNewMywarning;

    @Override
    public boolean onSupportNavigateUp() {
        //to create button in actionBar for navigation to MainActivity/PreviousScreen
        this.startActivity(new Intent(this,MainActivity.class));
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_warnings);

        //to get the backButton on actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNewMywarning=findViewById(R.id.add_new_mywarning_btn);

        warningsRecycler=findViewById(R.id.recycleview_mywarnings);

        recycleMyWarningItemsAdapter=new RecycleMyWarningItemsAdapter(this,warningsList);
        warningsRecycler.setLayoutManager(new LinearLayoutManager(this));
        warningsRecycler.setItemAnimator(new DefaultItemAnimator());
        warningsRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        warningsRecycler.setAdapter(recycleMyWarningItemsAdapter);
        recycleMyWarningItemsAdapter.notifyDataSetChanged();

        addNewMywarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigation to next screen
                startActivity(new Intent(getApplicationContext(),AddMyWarningActivity.class));
            }
        });




    }
}
