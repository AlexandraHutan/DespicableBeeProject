package com.example.appprototype1;

import com.example.appprototype1.apiary.NoApiariesActivity;
import com.example.appprototype1.hive.NoHiveActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;



public class MainMenu extends AppCompatActivity {

    Button apiariesButton;
    Button hivesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        apiariesButton = findViewById(R.id.button2);
        hivesButton = findViewById(R.id.button3);

        apiariesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoApiariesActivity.class);
                startActivity(intent);
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