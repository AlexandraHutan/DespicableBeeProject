package com.example.appprototype1.apiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.Toast;

import com.example.appprototype1.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ApiariesActivity extends AppCompatActivity {
    ImageButton newApiaryBTN;
    RecyclerView apiariesListRV;
    DatabaseReference database;
    ArrayList<String> apiariesList = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiaries);
        apiariesListRV = (RecyclerView) findViewById(R.id.apiariesListRV);
        database = FirebaseDatabase.getInstance().getReference("Users").child("Apiaries");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                apiariesList.clear();
                for(DataSnapshot snapshot1: datasnapshot.getChildren()){
                    apiariesList.add(snapshot1.getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        for(String str : apiariesList){
            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
        }
        ApiaryAdapter apiaryAdapter = new ApiaryAdapter(apiariesList);
        apiariesListRV.setAdapter(apiaryAdapter);


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