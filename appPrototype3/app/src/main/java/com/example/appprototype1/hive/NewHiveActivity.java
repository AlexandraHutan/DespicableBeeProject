package com.example.appprototype1.hive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.appprototype1.MainMenu;
import com.example.appprototype1.R;

public class NewHiveActivity extends AppCompatActivity {


    Spinner dropdown;
    Spinner dropdown2;
    Spinner dropdown3;
    Spinner dropdown4;
    ElegantNumberButton elegantNumberButton;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    Button savebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hive);

        dropdown = findViewById(R.id.newHiveSpinner);
        dropdown2 = findViewById(R.id.newHiveSpinner2);
        dropdown3 = findViewById(R.id.newHiveSpinner3);
        dropdown4 = findViewById(R.id.newHiveSpinner4);
        elegantNumberButton = (ElegantNumberButton)findViewById(R.id.elegantbutton);
        savebutton = findViewById(R.id.savebutton);

        String[] items = new String[]{"4 frames", "5 frames", "8 frames", "10 frames"};
        String[] items2 = new String[]{"Extract", "From", "Database"};
        String[] items3 = new String[]{"Builder","Honey Production","Mating Nuc", "Mother Hive", "Nucleus", "Starter"};
        String[] item4 = new String[]{"White","Yellow","Red","Green","Blue"};

        adapter = new ArrayAdapter<>(this, R.layout.list_dropdown, items);
        adapter2 = new ArrayAdapter<>(this, R.layout.list_dropdown, items2);
        adapter3 = new ArrayAdapter<>(this, R.layout.list_dropdown, items3);
        adapter4 = new ArrayAdapter<>(this, R.layout.list_dropdown,item4);

        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter2);
        dropdown3.setAdapter(adapter3);
        dropdown4.setAdapter(adapter4);

        elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = elegantNumberButton.getNumber();
                Log.e("NUM",num);
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HiveDetailsActivity.class);
                startActivity(intent);
            }
        });

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