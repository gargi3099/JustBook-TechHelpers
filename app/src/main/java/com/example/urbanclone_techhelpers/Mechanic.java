package com.example.application2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanclone_techhelpers.Model;
import com.example.urbanclone_techhelpers.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Mechanic extends AppCompatActivity {
   RecyclerView r;
   private FirebaseDatabase FD;
   private DatabaseReference FR;
   myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);
        r=(RecyclerView)findViewById(R.id.rv);
        r.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FD.getInstance().getReference().child("Service Providers").child("mechanic"), Model.class)
                        .build();
        adapter=new myadapter(options,getApplicationContext());
        r.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        Intent i= new Intent(getApplicationContext(),com.example.application2.Home.class);
        startActivity(i);
    }
}