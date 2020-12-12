package com.example.application2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.application2.R;
import com.example.urbanclone_techhelpers.Feed;
import com.example.urbanclone_techhelpers.Model;
import com.example.urbanclone_techhelpers.myadapter;
import com.example.urbanclone_techhelpers.myfeedadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class Details extends AppCompatActivity {
    RecyclerView r2;
    myfeedadapter fadapter;
    FirebaseDatabase mD;
    DatabaseReference mR;
    TextView tn,tp,te,tu,ta;
    RatingBar Rb2;
    CircleImageView c;
    Button tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        r2 = (RecyclerView) findViewById(R.id.rv2);
        r2.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Feed> options =
                new FirebaseRecyclerOptions.Builder<Feed>()
                        .setQuery(mD.getInstance().getReference().child("Feedback Data"), Feed.class)
                        .build();
        fadapter = new myfeedadapter(options, getApplicationContext());
        r2.setAdapter(fadapter);
        c = (CircleImageView) findViewById(R.id.imglogo);
        tn = (TextView) findViewById(R.id.tname);
        tp = (TextView) findViewById(R.id.tphn);
        te = (TextView) findViewById(R.id.temail);
        tu = (TextView) findViewById(R.id.tus);
        ta = (TextView) findViewById(R.id.taddr);
        Rb2=(RatingBar) findViewById(R.id.rb);
        tb = (Button) findViewById(R.id.tbtn);
        Intent intent = getIntent();
        String i = intent.getStringExtra("position");
        SharedPreferences sharedPreferences = getSharedPreferences("category", MODE_PRIVATE);
        String value = sharedPreferences.getString("c", "");
        mR = mD.getInstance().getReference().child("Service Providers").child(value).child(i);
        mR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();
                String address = snapshot.child("address").getValue().toString();
                String e = snapshot.child("email").getValue().toString();
                String username = snapshot.child("username").getValue().toString();
                String phone = snapshot.child("phone").getValue().toString();
                String rating= snapshot.child("avgrating").getValue().toString();
                tn.setText(name);
                tp.setText(phone);
                ta.setText(address);
                tu.setText(username);
                te.setText(e);
                Float rates= Float.valueOf(rating);
                Rb2.setRating(rates);
                //app:layout_constraintHorizontal_bias="1.0"
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
        @Override
        protected void onStart () {
            super.onStart();
            fadapter.startListening();
        }
        @Override
        protected void onStop () {
            super.onStop();
            fadapter.stopListening();
        }

    public void Confirm(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("techemail", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("value", te.getText().toString());
        editor.apply();
        Intent intent=new Intent(this, com.example.application2.Confirm.class);
        startActivity(intent);
    }

    public void visible(View view) {
        r2.setVisibility(View.VISIBLE);
    }
}