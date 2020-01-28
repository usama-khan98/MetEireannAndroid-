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

import static com.example.mymeteireannclone.MyWarningsActivity.warningsList;


//Usama Ali Khan
//17810

//activity class to edit values of my warnings in list

public class EditMyWarningsActivity extends AppCompatActivity {

    private Spinner areaSpinner,levelSpinner,typeSpinner;
    private String area,level,type;
    private RecycleMyWarningItemsAdapter recycleMyWarningItemsAdapter;
    private Button editBtn,cancelEdit,deleteBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_warnings);

        final int position=getIntent().getIntExtra("position",0);

        WarningItem oldItem=MyWarningsActivity.warningsList.get(position);

        //find spinner's view
        areaSpinner=findViewById(R.id.select_area_spinner_edit);
        levelSpinner=findViewById(R.id.select_level_spinner_edit);
        typeSpinner=findViewById(R.id.select_type_spinner_edit);

        editBtn=findViewById(R.id.edit_warning_btn);
        cancelEdit=findViewById(R.id.final_cancel_edit_warning_btn);
        deleteBtn=findViewById(R.id.delete_warning_btn);

        //create adapter
        ArrayAdapter<CharSequence> areaAdapter = ArrayAdapter.createFromResource(this, R.array.area_array, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);

        //getting previous value of warning item and setting them in spinner
        int oldAreaPos=areaAdapter.getPosition(oldItem.getArea());
        areaSpinner.setSelection(oldAreaPos);

        //add on item selected listerners to spinner
        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

        //getting previous value of warning item and setting them in spinner
        int oldLevelPos=levelAdapter.getPosition(oldItem.getLevel());
        levelSpinner.setSelection(oldLevelPos);

        //add on item selected listerners to spinner
        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

        //getting previous value of warning item and setting them in spinner
        int oldTypePos=typeAdapter.getPosition(oldItem.getType());
        typeSpinner.setSelection(oldTypePos);
        //add on item selected listerners to spinner
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WarningItem witem=new WarningItem(area,level,type);
                //editing values of an existing warning item in list
                MyWarningsActivity.warningsList.set(position,witem);

                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });

        cancelEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleting an existing warning item in list
                MyWarningsActivity.warningsList.remove(position);

                startActivity(new Intent(getApplicationContext(),MyWarningsActivity.class));
            }
        });


    }
}
