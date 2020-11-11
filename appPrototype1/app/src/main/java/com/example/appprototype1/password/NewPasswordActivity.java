package com.example.appprototype1.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appprototype1.MainActivity;
import com.example.appprototype1.R;
import com.example.appprototype1.R.*;

public class NewPasswordActivity extends AppCompatActivity {
    Button resetPasswordBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_new_password);
        resetPasswordBTN = (Button) findViewById(R.id.newPasswordBTN);
        resetPasswordBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}