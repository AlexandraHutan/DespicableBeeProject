package com.example.appprototype1.hive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appprototype1.R;

public class NewHiveActivity extends AppCompatActivity {


    Spinner dropdown;
    Spinner dropdown2;
    Spinner dropdown3;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hive);

        dropdown = findViewById(R.id.newHiveSpinner);
        dropdown2 = findViewById(R.id.newHiveSpinner2);
        dropdown3 = findViewById(R.id.newHiveSpinner3);

        String[] items = new String[]{"4 frames", "5 frames", "8 frames", "10 frames"};
        String[] items2 = new String[]{"Extract", "From", "Database"};
        String[] items3 = new String[]{"Nucleus","Mating Nuc"};

        adapter = new ArrayAdapter<>(this, R.layout.list_dropdown, items);
        adapter2 = new ArrayAdapter<>(this, R.layout.list_dropdown, items2);
        adapter3 = new ArrayAdapter<>(this, R.layout.list_dropdown, items3);
        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter2);
        dropdown3.setAdapter(adapter3);

//        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 1) {
//                    items3 = new String[]{"Nucleus", "Mating Nuc"};
//                    //adapter3 = new ArrayAdapter<>(parent, R.layout.list_dropdown, items3);
//                    adapter3.notifyDataSetChanged();
//                    Toast.makeText(getApplicationContext(),"This works",Toast.LENGTH_LONG).show();
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

}