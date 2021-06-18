package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class Address extends AppCompatActivity {

    String mAddress;
    EditText name,flatname,street,pincode,state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent intent = getIntent();
        Button back = findViewById(R.id.back);

        name = (EditText) findViewById(R.id.name_edittext);
        flatname = (EditText) findViewById(R.id.flatname_edittext);
        street = (EditText) findViewById(R.id.street_edittext);
        pincode = (EditText) findViewById(R.id.pincode_edittext);
        state = (EditText) findViewById(R.id.state_edittext);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddress = name.getText().toString() + "," + flatname.getText().toString() + "," +
                           street.getText().toString() + "," + pincode.getText().toString() + "," +
                           state.getText().toString();

                try {
                    DbUtility.insertValues(MainActivity.mActivity,MainActivity.mLocation, MainActivity.mCategories, MainActivity.mItemDuration,MainActivity.mItemWorkingCondition, MainActivity.mItemPickup,mAddress, Dropyourselfcontent.mDropAddress);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}