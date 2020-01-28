package com.example.mymeteireannclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


//Usama Ali Khan
//17810

//activity class for adding new my warnings

public class AddMyWarningActivity extends AppCompatActivity{

    private Spinner areaSpinner,levelSpinner,typeSpinner;
    private String area="",level="",type="";
    private RecycleMyWarningItemsAdapter recycleMyWarningItemsAdapter;
    private Button addButton,cancelAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_my_warnings);


        //find spinner's view
        areaSpinner=findViewById(R.id.select_area_spinner);
        levelSpinner=findViewById(R.id.select_level_spinner);
        typeSpinner=findViewById(R.id.select_type_spinner);

        addButton=findViewById(R.id.final_add_warning_btn);
        cancelAdd=findViewById(R.id.final_cancel_add_warning_btn);

        //create adapter
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(this, R.array.area_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);

        //add on item selected listerners to spinner
        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getting value selected from spinner
                area=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //create adapter
        ArrayAdapter<CharSequence> levelAdapter = ArrayAdapter.createFromResource(this, R.array.level_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);

        //add on item selected listerners to spinner
        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getting value selected from spinner
                level=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //create adapter
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.type_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        //add on item selected listerners to spinner
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //getting value selected from spinner
                type=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WarningItem witem=new WarningItem(area,level,type);

                //adding new warning item in warnings list
                MyWarningsActivity.warningsList.add(witem);

                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });

        cancelAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });




    }

}
