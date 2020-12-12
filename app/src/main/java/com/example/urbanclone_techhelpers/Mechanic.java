package com.example.application2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application2.Details;
import com.example.application2.R;
import com.example.urbanclone_techhelpers.Model;
import com.example.urbanclone_techhelpers.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
}