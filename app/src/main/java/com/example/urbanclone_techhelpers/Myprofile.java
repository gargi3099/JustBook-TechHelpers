package com.example.application2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class Myprofile extends AppCompatActivity {
private TextView t1,t2,t3,t4,t5;
private CircleImageView i;
private String email;
private FirebaseDatabase PD;
private DatabaseReference PR;
private FirebaseAuth fAuth;
private static final String USERDATA="User Data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        t1=(TextView)findViewById(R.id.t41);
        t2=(TextView)findViewById(R.id.t42);
        t3=(TextView)findViewById(R.id.t43);
        t4=(TextView)findViewById(R.id.t44);
        t5=(TextView)findViewById(R.id.t45);
        i=(CircleImageView)findViewById(R.id.imglogo);
        fAuth = FirebaseAuth.getInstance();
        email=fAuth.getCurrentUser().getEmail().toString();
        PD=FirebaseDatabase.getInstance();
        PR=PD.getReference().child(USERDATA);
        PR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    if(ds.child("email").getValue().equals(email)){
                       t1.setText(ds.child("name").getValue(String.class));
                        t2.setText("PHONE: "+ds.child("phone").getValue(String.class));
                        t3.setText("ADDRESS: "+ds.child("address").getValue(String.class));
                        t4.setText("USERNAME: "+ds.child("username").getValue(String.class));
                        t5.setText("EMAIL: "+ds.child("email").getValue(String.class));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent i= new Intent(getApplicationContext(),com.example.application2.Home.class);
        startActivity(i);
    }
}