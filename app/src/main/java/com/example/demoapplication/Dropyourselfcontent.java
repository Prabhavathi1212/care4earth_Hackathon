package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Dropyourselfcontent extends AppCompatActivity {
    public static String mDropAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropyourselfcontent);

        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dropyourselfcontent.this,finalactivity.class);
                startActivity(intent);
            }
        });

        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dropyourselfcontent.this,finalactivity.class);
                startActivity(intent);
            }
        });
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dropyourselfcontent.this,finalactivity.class);
                startActivity(intent);
            }
        });


        RadioGroup radioGroupItemDrop = findViewById(R.id.dropaddress);
        radioGroupItemDrop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroupItemDrop.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                mDropAddress=rb.getText().toString();
            }
        });

    }
}