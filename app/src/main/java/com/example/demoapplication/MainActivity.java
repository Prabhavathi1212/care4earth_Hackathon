package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static Activity mActivity;
    public  static String mLocation,mCategories,mItemDuration,mItemWorkingCondition,mItemPickup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mActivity = MainActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                mLocation = spinner.getItemAtPosition(i).toString();
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });

        Spinner spinneritemworkingcondition = findViewById(R.id.item_working_condition);
        spinneritemworkingcondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                mItemWorkingCondition = spinneritemworkingcondition.getItemAtPosition(i).toString();
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });


        try {
            DbUtility.initDButility(MainActivity.this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RadioButton radioButton = findViewById(R.id.doorstep);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this,PickFromDoorStepActivity.class);
             startActivity(intent);
            }
        });

        RadioButton radioButtonDropYourself = findViewById(R.id.dropyourself);
        radioButtonDropYourself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Dropyourselfcontent.class);
                startActivity(intent);
            }
        });

        RadioGroup radioGroup = findViewById(R.id.category_grp);
         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 int id=radioGroup.getCheckedRadioButtonId();
                 RadioButton rb=(RadioButton) findViewById(id);
                 mCategories=rb.getText().toString();
             }
         });

        RadioGroup radioGroupItemDuration = findViewById(R.id.category_grp);
        radioGroupItemDuration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroupItemDuration.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                mItemDuration=rb.getText().toString();
            }
        });


        RadioGroup radioGroupItemPickup = findViewById(R.id.itempickup);
        radioGroupItemPickup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroupItemPickup.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                mItemPickup=rb.getText().toString();
            }
        });

    }
}