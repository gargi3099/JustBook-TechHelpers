package com.example.urbanclone_techhelpers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.application2.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Plumber extends AppCompatActivity {
    RecyclerView r;
    private FirebaseDatabase FD;
    private DatabaseReference FR;
    myadapter adapter;
    ProgressDialog progressDialog;
    private final static int PROGRESS=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        r=(RecyclerView)findViewById(R.id.rvp);
        r.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        },PROGRESS);
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FD.getInstance().getReference().child("Service Providers").child("plumber"), Model.class)
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