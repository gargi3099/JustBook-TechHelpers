package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.application2.R;

public class Mechanic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);
    }

    public void Details(View view)
    {
        Intent intent=new Intent(this, com.example.application2.Details.class);
        startActivity(intent);
    }
}