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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    Button button;
    EditText name,phn,email,pwd,cpwd,un,add;
    FirebaseAuth fAuth;
    DatabaseReference ref;
    com.example.application2.UserData member;

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
        fAuth = FirebaseAuth.getInstance();
        if(fAuth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(Register.this, com.example.application2.Home.class);
            startActivity(intent);
            finish();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String e = email.getText().toString();
                String p = pwd.getText().toString();
                final String n = name.getText().toString();
                final String address = add.getText().toString();
                final String username = un.getText().toString();
                final String mobile = phn.getText().toString();
                member = new com.example.application2.UserData();
                ref = FirebaseDatabase.getInstance().getReference().child("User Data");
                if(validate()) {
                    fAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                member.setName(n);
                                member.setPhone(mobile);
                                member.setUsername(username);
                                member.setAddress(address);
                                member.setEmail(e);
                                ref.push().setValue(member)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful())
                                                {
                                                    Toast.makeText(getBaseContext(), "Signup Successful", Toast.LENGTH_LONG).show();
                                                    button.setEnabled(true);
                                                    Intent intent = new Intent(Register.this, com.example.application2.Login.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        });
                            }
                            else{
                                Toast.makeText(getBaseContext(), "Signup Failed", Toast.LENGTH_LONG).show();
                                button.setEnabled(true);
                            }
                        }
                    });
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
            name.setError("Enter at least 3 characters");
            valid = false;
        } else {
            name.setError(null);
        }
        if(mobile.isEmpty() || mobile.length() < 10 || !mobile.matches("[0-9]{10}")) {
            phn.setError("Enter a valid mobile number");
            valid = false;
        } else {
            phn.setError(null);
        }
        if (u.isEmpty() || u.length() < 3) {
            un.setError("Enter at least 3 characters");
            valid = false;
        } else {
            un.setError(null);
        }

        if (a.isEmpty() ) {
            add.setError("Address field required");
            valid = false;
        } else {
            add.setError(null);
        }
        if (e.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            email.setError("Enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        if (p.isEmpty() || p.length() < 4 || p.length() > 10) {
            pwd.setError("Range 4-10 alphanumeric characters");
            valid = false;
        }else {
            pwd.setError(null);
        }

        if (p.equals(cp)){
            cpwd.setError(null);
            psisequal = true;
        }else {
            cpwd.setError("Passwords do not match");
            valid = false;
            psisequal = false;
        }

        return valid;
    }
}