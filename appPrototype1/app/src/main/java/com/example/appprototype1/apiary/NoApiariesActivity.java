package com.example.appprototype1.apiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.appprototype1.R;

public class NoApiariesActivity extends AppCompatActivity {
    ImageButton newApiaryBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_apiaries);

        newApiaryBTN = findViewById(R.id.newApiaryBTN);
        newApiaryBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewApiaryActivity.class);
                startActivity(intent);
            }
        });
    }
}