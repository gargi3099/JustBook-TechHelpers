package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Booked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
    }

    public void Thanks(View view)
    {
        Intent intent=new Intent(this, com.example.application2.Thanks.class);
        startActivity(intent);
    }
}