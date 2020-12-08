package com.example.application2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button button1,button2;
    EditText username,password;
    FirebaseAuth fAuth;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("LOGIN");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        button1 = (Button)findViewById(R.id.btnregister);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, com.example.application2.Register.class);
                startActivity(intent);
            }
        });
        button2 =(Button)findViewById(R.id.btnlogin);
        username=(EditText)findViewById(R.id.etusername);
        password=(EditText)findViewById(R.id.etPassword);
        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(com.example.application2.Login.this, com.example.application2.Home.class);
            startActivity(intent);
            finish();
        }
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= username.getText().toString();
                String pswd= password.getText().toString();
                fAuth.signInWithEmailAndPassword(email,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this, com.example.application2.Home.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                );
            }
        });


    }
}