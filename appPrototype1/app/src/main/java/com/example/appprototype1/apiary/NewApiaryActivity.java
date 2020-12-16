package com.example.appprototype1.apiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appprototype1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewApiaryActivity extends AppCompatActivity {
    EditText apiaryNameET1;
    EditText apiaryLocationET2;
    EditText apiaryNotesET3;

    DatabaseReference database;
    FirebaseAuth firebaseAuth;

    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_apiary);

        apiaryNameET1 = (EditText) findViewById(R.id.apiaryNameET1);
        apiaryLocationET2 = (EditText) findViewById(R.id.apiaryLocationET2);
        apiaryNotesET3 = (EditText) findViewById(R.id.apiaryNotesET3);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference("Users").child(firebaseAuth.getCurrentUser().getUid()).child("Apiaries");



        saveBtn = findViewById(R.id.noApiariesBTN);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addApairy();
            Intent intent = new Intent(v.getContext(),ApiariesActivity.class);
            startActivity(intent);
            }
        });
    }

    private void addApairy(){
        Apiary apiary = new Apiary(apiaryNameET1.getText().toString().trim(),
                apiaryLocationET2.getText().toString().trim(),
                apiaryNotesET3.getText().toString().trim());
        Toast.makeText(getApplicationContext(), apiary.getLocationName() + " " + apiary.getNotesName(), Toast.LENGTH_LONG).show();
        database.child(apiary.getApiaryName()).setValue(apiary).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Apiary Added", Toast.LENGTH_LONG).show();
                }
//                                    else{
//                                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
            }
        });
    }
}