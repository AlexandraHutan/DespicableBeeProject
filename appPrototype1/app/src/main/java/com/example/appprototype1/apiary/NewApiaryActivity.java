package com.example.appprototype1.apiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.appprototype1.R;

public class NewApiaryActivity extends AppCompatActivity {

    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_apiary);

        saveBtn = findViewById(R.id.noApiariesBTN);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ApiariesActivity.class);
                startActivity(intent);
            }
        });
    }
}