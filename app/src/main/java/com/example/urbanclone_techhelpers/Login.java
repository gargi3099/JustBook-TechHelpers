package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    Button button1,button2;
    EditText username,password;
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
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        button2 =(Button)findViewById(R.id.btnlogin);
        username=(EditText)findViewById(R.id.etusername);
        password=(EditText)findViewById(R.id.etPassword);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  if(username.getText().toString().equals("admin") && password.getText().toString().equals("123")) {
                      Intent intent = new Intent(Login.this, Home.class);
                      startActivity(intent);
                  }
                  else{
                      password.setError("incorrect username or password");
                  }
            }
        });


    }
}