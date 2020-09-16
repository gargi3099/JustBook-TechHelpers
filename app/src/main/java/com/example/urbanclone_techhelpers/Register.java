package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Button button;
    EditText name,phn,email,pwd,cpwd,un,add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("REGISTER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        button = (Button) findViewById(R.id.btnregister);
        name = (EditText)findViewById(R.id.etname);
        email = (EditText)findViewById(R.id.etemail);
        add = (EditText)findViewById(R.id.etaddress);
        phn= (EditText)findViewById(R.id.etphone);
        pwd = (EditText)findViewById(R.id.etPwd);
        cpwd = (EditText)findViewById(R.id.etConfirmPwd);
        un = (EditText)findViewById(R.id.etun);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    Toast.makeText(getBaseContext(), "Signup Successful", Toast.LENGTH_LONG).show();
                    button.setEnabled(true);
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(), "Signup Failed", Toast.LENGTH_LONG).show();
                    button.setEnabled(true);
                }
            }
        });
    }
    private final boolean validate() {
        boolean valid = true;
        boolean psisequal;

        String n=name.getText().toString();
        String e = email.getText().toString();
        String p = pwd.getText().toString();
        String cp = cpwd.getText().toString();
        String a = add.getText().toString();
        String u = un.getText().toString();
        String mobile = phn.getText().toString();

        if (n.isEmpty() || n.length() < 3) {
            name.setError("enter at least 3 characters");
            valid = false;
        } else {
            name.setError(null);
        }
        if(mobile.isEmpty() || mobile.length() < 10 || !mobile.matches("[0-9]{10}")) {
            phn.setError("enter a valid mobile number");
            valid = false;
        } else {
            phn.setError(null);
        }
        if (u.isEmpty() || u.length() < 3) {
            un.setError("enter at least 3 characters");
            valid = false;
        } else {
            un.setError(null);
        }

        if (a.isEmpty() ) {
            add.setError("fill address field");
            valid = false;
        } else {
            add.setError(null);
        }
        if (e.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        if (p.isEmpty() || p.length() < 4 || p.length() > 10) {
            pwd.setError("range 4-10 alphanumeric characters");
            valid = false;
        }else {
            pwd.setError(null);
        }

        if (p.equals(cp)){
            cpwd.setError(null);
            psisequal = true;
        }else {
            cpwd.setError("passwords do not match");
            valid = false;
            psisequal = false;
        }

        return valid;
    }
}