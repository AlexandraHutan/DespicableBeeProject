package com.example.appprototype1.hive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.appprototype1.R;
import com.example.appprototype1.apiary.NewApiaryActivity;

public class NoHiveActivity extends AppCompatActivity {
    ImageButton newHiveBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_hive);

        newHiveBTN = findViewById(R.id.newHiveBTN);
        newHiveBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewHiveActivity.class);
                startActivity(intent);
            }
        });
    }
}