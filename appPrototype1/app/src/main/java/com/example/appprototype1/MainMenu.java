package com.example.appprototype1;

import com.example.appprototype1.apiary.ApiariesActivity;
import com.example.appprototype1.apiary.NoApiariesActivity;
import com.example.appprototype1.hive.NoHiveActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainMenu extends AppCompatActivity {

    Button apiariesButton;
    Button hivesButton;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        firebaseAuth = FirebaseAuth.getInstance();

        apiariesButton = findViewById(R.id.button2);
        hivesButton = findViewById(R.id.button3);

        apiariesButton.setOnClickListener(new View.OnClickListener() {
            final ArrayList<String> apiariesList = new ArrayList<>();
            @Override
            public void onClick(View v) {
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
                if(apiariesList != null){
                    for(String str : apiariesList){
                        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(getApplicationContext(), ApiariesActivity.class);
                    intent.putExtra("apiariesList", apiariesList);
                    startActivity(intent);

                }
                else {
                    Intent intent = new Intent(getApplicationContext(), NoApiariesActivity.class);
                    startActivity(intent);
                }
            }
        });

        hivesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoHiveActivity.class);
                startActivity(intent);
            }
        });
    }

}