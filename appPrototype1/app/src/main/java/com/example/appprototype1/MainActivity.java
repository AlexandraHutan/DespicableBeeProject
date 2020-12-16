 package com.example.appprototype1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appprototype1.password.ForgotPassword1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

 public class MainActivity extends AppCompatActivity {

    private TextView login_signup, tv_forgotPass;
    private Button loginButton;
    private FirebaseAuth firebaseAuth;
    private EditText loginEmailAddress,loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setupOnClickListeners();
    }

    private void initialize(){
        login_signup = (TextView) findViewById(R.id.LoginSignUp);
        loginButton = (Button) findViewById(R.id.loginBtn);
        tv_forgotPass = (TextView) findViewById(R.id.tv_forgotPass);
        firebaseAuth = FirebaseAuth.getInstance();
        loginEmailAddress = (EditText) findViewById(R.id.loginEmailAddress);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
    }

    private void setupOnClickListeners(){


        login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(!Patterns.EMAIL_ADDRESS.matcher(loginEmailAddress.getText().toString().trim()).matches())
                    Toast.makeText(getApplicationContext(),"Enter a valid email",Toast.LENGTH_LONG).show();
                else if( loginPassword.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter a password",Toast.LENGTH_LONG).show();
                else
                    signIn(loginEmailAddress.getText().toString(),loginPassword.getText().toString());
            }
        });

        tv_forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), ForgotPassword1.class);
                startActivity(intent3);
            }
        });
    }

    private void signIn(final String email, final String password){
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Sign In Successful",Toast.LENGTH_LONG).show();
                            Intent intent2 = new Intent(getApplicationContext(),MainMenu.class);
                            startActivity(intent2);
                            finish();
                        }
                        else {
                            FirebaseAuthException e = (FirebaseAuthException) task.getException();
                            Toast.makeText(getApplication(), "Failed Registration: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}