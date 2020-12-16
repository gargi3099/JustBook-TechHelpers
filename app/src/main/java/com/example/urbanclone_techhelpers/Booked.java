package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Booked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        Intent intent=getIntent();
        Bundle extras =  intent.getExtras();
        String date = extras.getString("DATE");
        String time = extras.getString("TIME");
        TextView viewTextD = (TextView) findViewById(R.id.tvbdate);
        TextView viewTextT = (TextView) findViewById(R.id.textView_time);
        viewTextD.setText("Date : "+date);
        viewTextT.setText("Time : "+time);
    }

    public void Thanks(View view)
    {
        Intent intent=new Intent(this, com.example.application2.Thanks.class);
        startActivity(intent);
    }
}