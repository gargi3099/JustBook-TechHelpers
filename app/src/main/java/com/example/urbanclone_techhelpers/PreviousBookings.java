package com.example.application2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urbanclone_techhelpers.Book;
import com.example.urbanclone_techhelpers.Model;
import com.example.urbanclone_techhelpers.bookadapter;
import com.example.urbanclone_techhelpers.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PreviousBookings extends AppCompatActivity {

    RecyclerView r;
    private FirebaseDatabase FD;
    private DatabaseReference FR;
    bookadapter adapter;
    FirebaseAuth authf = FirebaseAuth.getInstance();
    String email = authf.getCurrentUser().getEmail().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_bookings);
        r=(RecyclerView)findViewById(R.id.rv);
        r.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Book> options =
                new FirebaseRecyclerOptions.Builder<Book>()
                        .setQuery(FD.getInstance().getReference().child("Bookings").orderByChild("email").equalTo(email), Book.class)
                        .build();
        adapter=new bookadapter(options,getApplicationContext());
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