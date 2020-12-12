package com.example.application2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application2.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {
    FirebaseAuth authf;
    Button bb;
    EditText fbr, fbc;
    private FirebaseDatabase FFD;
    private DatabaseReference FFR;
    com.example.urbanclone_techhelpers.feedbackdata feeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        SharedPreferences sharedPreferences = getSharedPreferences("techemail", MODE_PRIVATE);
        final String value = sharedPreferences.getString("value","");
        bb = (Button) findViewById(R.id.btns);
        fbc = (EditText) findViewById(R.id.etfbc);
        fbr = (EditText) findViewById(R.id.etfbr);
        authf = FirebaseAuth.getInstance();
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String c = fbc.getText().toString();
                final String r = fbr.getText().toString();
                feeds = new com.example.urbanclone_techhelpers.feedbackdata();
                FFR = FirebaseDatabase.getInstance().getReference().child("Feedback Data");
                authf = FirebaseAuth.getInstance();
                String email = authf.getCurrentUser().getEmail().toString();
                if (validates()) {
                    feeds.setRating(r);
                    feeds.setComment(c);
                    feeds.setEmail(email);
                    feeds.setTechemail(value);
                    FFR.push().setValue(feeds)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getBaseContext(), "Booking Done", Toast.LENGTH_LONG).show();
                                        bb.setEnabled(true);
                                        Intent intent=new Intent(Feedback.this, Home.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getBaseContext(), "Give a valid feedback", Toast.LENGTH_LONG).show();
                    bb.setEnabled(true);
                }
            }
        });
        
    }
               


    private final boolean validates() {
        boolean valid = true;
        String rt = fbr.getText().toString();
        String ct = fbc.getText().toString();
        if (rt.isEmpty() || !rt.matches("([1-5][.])?[5]") ) {
            fbr.setError("Please rate the service between 0 to 5");
            valid = false;
        } else {
            fbr.setError(null);
        }
        if (ct.isEmpty()) {
            fbc.setError("Please enter a review ");
            valid = false;
        } else {
            fbc.setError(null);
        }

        return valid;
    }
}