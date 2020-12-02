package com.example.appprototype1.hive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.appprototype1.R;

public class HivesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hives);

        String[] menuItems = {"Hive One", "Hive Two", "Hive Three"};

        ListView listView = (ListView) findViewById(R.id.hivesList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this, R.layout.list,menuItems);
        listView.setAdapter(listViewAdapter);
    }
}