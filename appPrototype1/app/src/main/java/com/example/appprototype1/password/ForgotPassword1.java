package com.example.appprototype1.password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appprototype1.R;

public class ForgotPassword1 extends AppCompatActivity {
    Button newPasswordBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password1);

        newPasswordBtn = findViewById(R.id.sendInstructionBTN);
        newPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),NewPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}