package com.example.appprototype1;

import androidx.annotation.BoolRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appprototype1.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private DatabaseReference database;
    private EditText email_input_signup, password_input_signup, password_confirm_input;
    private Button signUp_btn;
    private TextView textViewB;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initialize();
        setUpOnClickListeners();
    }

    private void initialize(){
        signUp_btn = findViewById(R.id.singUp_btn);
        textViewB = findViewById(R.id.textViewB);
        email_input_signup = findViewById(R.id.email_input_signup);
        password_input_signup = findViewById(R.id.password_input_signup);
        password_confirm_input = findViewById(R.id.password_confirm_input);

        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = new ProgressBar(this);
        database = FirebaseDatabase.getInstance().getReference("Users");

    }

    private void setUpOnClickListeners(){

        signUp_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                register();
            }
        });

        textViewB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void register() {
        final String email = email_input_signup.getText().toString().trim();
        String password = password_input_signup.getText().toString().trim();
        String confirm = password_confirm_input.getText().toString().trim();

        if (email.isEmpty()) {
            email_input_signup.setError("Email is required!");
            email_input_signup.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_input_signup.setError("Please provide a valid email");
            email_input_signup.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            password_input_signup.setError("Password is required");
            password_input_signup.requestFocus();
            return;
        }
        if (confirm.isEmpty()) {
            password_confirm_input.setError("Confirm Password");
            password_confirm_input.requestFocus();
            return;
        }

        if(!password.equals(confirm)){
            password_confirm_input.setError("Passwords Do Not Match");
            password_confirm_input.requestFocus();
            return;
        }
//        database.setValue(email);
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(email);
                            uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            database.child(uid).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);
                                    }
//                                    else{
//                                        Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
                                }
                            });
                        }
                        else {

                            Toast.makeText(getApplication(), "Failed Registration: ", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                        } else
//                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_LONG).show();
//                    }
//                });
    }

}