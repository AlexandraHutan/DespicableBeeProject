package com.example.appprototype1.apiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.appprototype1.R;

public class ApiariesActivity extends AppCompatActivity {
    ImageButton newApiaryBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiaries);

        String[] menuItems = {"Apiary One", "Apiary Two", "Apiary Three"};

        ListView listView = (ListView) findViewById(R.id.apiariesList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, R.layout.list,menuItems);
        listView.setAdapter(listViewAdapter);

        newApiaryBTN = findViewById(R.id.newApiaryBTN2);
        newApiaryBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewApiaryActivity.class);
                startActivity(intent);
            }
        });
    }
}